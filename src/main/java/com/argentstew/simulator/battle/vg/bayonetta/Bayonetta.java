package com.argentstew.simulator.battle.vg.bayonetta;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.ComboStrike;
import com.argentstew.simulator.battle.trait.impl.Demonslayer;
import com.argentstew.simulator.battle.trait.impl.GodSlayer;
import com.argentstew.simulator.battle.trait.impl.TimeManipulation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.bayonetta
 * 4/5/2020
 *
 * @author argen
 */
public class Bayonetta {

    public static final String NAME = "Bayonetta";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.LIGHT, 1.25);
        defenses.set(AttackSubType.DARK, 1.25);

        FighterStats stats = FighterStats.builder().strength(6).toughness(3).dexterity(6).aim(8)
                .agility(7.5).speed(6).intellect(6).willpower(4).size(5.5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new GodSlayer(), new Demonslayer(), new ComboStrike(), new TimeManipulation()));
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("A speedy fighter with exceptional skill in battle due to her traits.")
                .entryQuotes(Arrays.asList("Bayonetta: 'Well, we can't be having that now can we!? Let's rock, baby!'",
                        "Bayonetta: 'Now it's time to be naughty.'"))
                .victoryQuotes(Arrays.asList("Bayonetta: 'Heaven and Hell can tear each other to pieces for all I care. I've got my own problems to worry about.'",
                        "Bayonetta: 'No one said you could touch!'"))
                .classifications(new ArrayList<FighterClassification>() {{ add(FighterClassification.HUMANOID); }})
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new LoveIsBlue()).addAction(new WitchTwist()).addAction(new AfterBurnerKick())
                .addAction(new PantherWithin())
                .addAction(new WickedWeaves())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
