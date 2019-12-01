package com.argentstew.simulator.battle.vg.kirby;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.bowser.Bowser;
import com.argentstew.simulator.battle.vg.mario.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.kirby
 * 8/26/2019
 *
 * @author Craig
 */
public class Kirby {

    public static final String NAME = "Kirby";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.9);
        defenses.set(AttackSubType.PIERCE, 1.25);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(8).dexterity(3.5).aim(4.5)
                .agility(6).speed(3.5).intellect(2.5).willpower(8).size(1).weight(1).build();
        FighterTraits traits = new FighterTraits(Collections.emptyList());
        return Fighter.builder().name(NAME).hp(125).maxHp(125).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Kirby: 'Hiii!'", "Kirby: 'Poyo!'"))
                .victoryQuotes(Arrays.asList("Kirby dances around after his win.",
                        "Kirby does a big spin and poses victoriously.'"))
                .classifications(Collections.singletonList(FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Inhale()).addAction(new CutterBoomerang()).addAction(new HammerFlip())
                .addAction(new VulcanJab()).addAction(new AirDrop()).addAction(new StoneChange())
                .addAction(new UltraSword())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
