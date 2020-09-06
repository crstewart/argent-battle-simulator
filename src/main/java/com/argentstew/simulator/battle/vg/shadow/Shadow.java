package com.argentstew.simulator.battle.vg.shadow;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Hazardous;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shadow
 * 3/28/2020
 *
 * @author argen
 */
public class Shadow {

    public static final String NAME = "Shadow";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.PIERCE, 1.25);
        defenses.set(AttackSubType.DARK, 1.2);
        defenses.set(AttackSubType.MYSTIC, 1.3);

        FighterStats stats = FighterStats.builder().strength(4).toughness(3).dexterity(6).aim(7)
                .agility(8.5).speed(9.5).intellect(4).willpower(5).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new NaturalAgility(), new Hazardous()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A speedy fighter with space-bending, undodgeable attacks.")
                .entryQuotes(Arrays.asList("Shadow: 'I am the Ultimate Life Form!'",
                        "Shadow: 'You best try your hardest...or else you'll get hurt!'"))
                .victoryQuotes(Arrays.asList("Shadow: 'I determine my own destiny.'",
                        "Shadow: 'You know I can't let you live. You're adventuring days are coming to an end.'"))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SpinDash()).addAction(new HomingAttack()).addAction(new ChaosControl())
                .addAction(new ChaosSpear())
                .addAction(new ChaosBlast())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
