package com.argentstew.simulator.battle.vg.chunli;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.ryu.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.chunli
 * 3/28/2020
 *
 * @author argen
 */
public class ChunLi {

    public static final String NAME = "Chun Li";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.95);
        defenses.set(AttackSubType.KICK, 0.9);
        defenses.set(AttackSubType.HEADBUTT, 0.95);
        defenses.set(AttackSubType.SLAM, 0.95);
        defenses.set(AttackSubType.CHI, 0.95);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5).dexterity(6).aim(5)
                .agility(6).speed(5).intellect(5).willpower(5).size(5).weight(4.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(145).maxHp(145).xStrikeMeter(0)
                .description("An all-around fighter with powerful kick attacks.")
                .entryQuotes(Arrays.asList("Chun Li: 'You ready for this?'",
                        "Chun Li: 'Ready when you are.'"))
                .victoryQuotes(Arrays.asList("Chun Li: 'I'm the strongest woman in the world.'",
                        "Chun Li: 'I fight for my beliefs. That's why I never lose!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new HyakuretsuKyaku()).addAction(new Kikoken()).addAction(new SpinningBirdKick())
                .addAction(new Koshuto())
                .addAction(new ShichiseiRanka())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
