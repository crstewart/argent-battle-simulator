package com.argentstew.simulator.battle.vg.johnmarston;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.niko.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.johnmarston
 * 4/4/2020
 *
 * @author argen
 */
public class JohnMarston {

    public static final String NAME = "John Marston";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.95);
        defenses.set(AttackSubType.PLASMA, 1.1);

        FighterStats stats = FighterStats.builder().strength(5).toughness(6.5).dexterity(6.5).aim(7.5)
                .agility(5).speed(4.5).intellect(4).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An old west weaponmaster with a lasso that can tie up and stop his opponents.")
                .entryQuotes(Arrays.asList("John Marston: 'My side ain't chosen. My side was given.'",
                        "John Marston: 'If you win power, remember why you wanted it.'"))
                .victoryQuotes(Arrays.asList("John Marston: 'I'm a semi-literate farmer and hired killer. I ain't in the power game.'",
                        "John Marston: 'While there are guns and money, there won't be any freedom.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new CattlemanRevolver()).addAction(new SawedoffShotgun()).addAction(new HuntingKnife())
                .addAction(new Lasso())
                .addAction(new GatlingGun())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
