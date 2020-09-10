package com.argentstew.simulator.battle.vg.banjo;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.bomberman.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.banjo
 * 4/5/2020
 *
 * @author argen
 */
public class BanjoKazooie {

    public static final String NAME = "Banjo & Kazooie";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.WATER, 1.1);
        defenses.set(AttackSubType.ICE, 1.1);
        defenses.set(AttackSubType.TOXIC, 1.25);
        defenses.set(AttackSubType.ASSIST, 0.7);

        FighterStats stats = FighterStats.builder().strength(6).toughness(7.5).dexterity(5.5).aim(5.5)
                .agility(4.5).speed(4.5).intellect(4).willpower(5.5).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).mp(0).maxMp(100).xStrikeMeter(0)
                .description("A brawler duo with a large mix of melee and ranged attacks.")
                .entryQuotes(Arrays.asList("Banjo: 'Guh-huh!'",
                        "Kazooie: 'You better prepare for the impending rush.'"))
                .victoryQuotes(Arrays.asList("Banjo: 'This is great! Have we finished now? Can I relax?'",
                        "Kazooie: 'They weren't the favorite character anyway...'"))
                .classifications(Collections.singletonList(FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new BlueEgg()).addAction(new FireEgg()).addAction(new GrenadeEgg())
                .addAction(new ClawSwipe()).addAction(new ForwardRoll()).addAction(new RatatatRap())
                .addAction(new SummonJinjonator())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
