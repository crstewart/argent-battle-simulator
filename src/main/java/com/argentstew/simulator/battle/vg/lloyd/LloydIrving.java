package com.argentstew.simulator.battle.vg.lloyd;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.kosmos.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.lloyd
 * 4/4/2020
 *
 * @author argen
 */
public class LloydIrving {

    public static final String NAME = "Lloyd Irving";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);

        FighterStats stats = FighterStats.builder().strength(4).toughness(4.5).dexterity(7.5).aim(4.5)
                .agility(6.5).speed(6).intellect(5.5).willpower(7).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A speedy fighter with fast sword techniques.")
                .entryQuotes(Arrays.asList("Lloyd: 'Give me your name and I'll give you mine!'",
                        "Lloyd: 'There is no meaning in dying!'"))
                .victoryQuotes(Arrays.asList("Lloyd: 'From the moment they are born, everyone has the right to live.'",
                        "Lloyd: 'Let's all work together for the sake of a peaceful world.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new TwinBlades()).addAction(new DemonFang()).addAction(new SonicThrust())
                .addAction(new SwordRain()).addAction(new GraveBlade())
                .addAction(new FalconsCrest())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
