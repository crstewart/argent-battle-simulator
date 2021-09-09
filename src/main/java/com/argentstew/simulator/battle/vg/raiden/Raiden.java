package com.argentstew.simulator.battle.vg.raiden;

import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.ComboStrike;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.trait.impl.Teleportation;
import com.argentstew.simulator.battle.vg.shaokahn.ShaoKahn;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.raiden
 * 3/26/2020
 *
 * @author argen
 */
public class Raiden {

    public static final String NAME = "Raiden";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(7).toughness(5).dexterity(8).aim(4)
                .agility(7.5).speed(8).intellect(7).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new Rival(ShaoKahn.NAME, 1.3), new ComboStrike(), new Teleportation()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A speedy fighter who strikes his opponents with electrically charged attacks.")
                .entryQuotes(Arrays.asList("Raiden: 'We have come to challenge you in Mortal Kombat.'",
                        "Raiden: 'I presume recent circumstances precipitate your arrival?'"))
                .victoryQuotes(Arrays.asList("Raiden: 'Your time has passed.'",
                        "Raiden: 'Have faith in the Elder Gods... have faith in me.'"))
                .classifications(Collections.singletonList(FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new LightningBolt()).addAction(new ChopKick()).addAction(new FlyingThunderGod())
                .addAction(new Electrocute())
                .addAction(new ElectricKnockout())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
