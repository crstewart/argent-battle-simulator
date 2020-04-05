package com.argentstew.simulator.battle.vg.bomberman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.scorpion.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bomberman
 * 4/5/2020
 *
 * @author argen
 */
public class Bomberman {

    public static final String NAME = "Bomberman";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();

        FighterStats stats = FighterStats.builder().strength(3).toughness(2.5).dexterity(7.5).aim(7.5)
                .agility(4).speed(4).intellect(4.5).willpower(4).size(4).weight(4).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).mp(0).maxMp(100).xStrikeMeter(0)
                .description("A weaponmaster with various explosive attacks.")
                .entryQuotes(Arrays.asList("Bomberman: 'Justice will prevail!'",
                        "Bomberman: 'Hard work always pays off...'"))
                .victoryQuotes(Arrays.asList("Bomberman: 'I won! It must be thanks to all my training!'",
                        "Bomberman: 'Thank you for being my opponent! That was a wonderful battle!'"))
                .classifications(Collections.singletonList(FighterClassification.ALIEN))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new FireBomb()).addAction(new ThunderBomb()).addAction(new WaterBomb())
                .addAction(new WindBomb())
                .addAction(new PowerBomb())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
