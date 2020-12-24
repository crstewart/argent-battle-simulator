package com.argentstew.simulator.battle.vg.metaknight;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.MeleeStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.trait.impl.Teleportation;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.metaknight
 * 3/27/2020
 *
 * @author argen
 */
public class Metaknight {

    public static final String NAME = "Meta Knight";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.AIR, 1.2);
        defenses.set(AttackSubType.DARK, 1.2);

        FighterStats stats = FighterStats.builder().strength(2.5).toughness(4).dexterity(10).aim(6)
                .agility(7).speed(7.5).intellect(6).willpower(7).size(1.5).weight(1.5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new NaturalAgility(), new Teleportation()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A speedy weaponmaster with a stealthy attack.")
                .entryQuotes(Arrays.asList("Meta Knight: 'Fight me!'", "Meta Knight: 'Know my power!'"))
                .victoryQuotes(Arrays.asList("Meta Knight: 'Come back when you can put up a fight.'",
                        "Meta Knight: 'Victory... is my destiny...'"))
                .classifications(Collections.singletonList(FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new MeleeStrategy()).build()
                .addAction(new Galaxia()).addAction(new MachTornado()).addAction(new DrillRush())
                .addAction(new DimensionalCape())
                .addAction(new GalaxiaDarkness())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
