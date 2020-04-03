package com.argentstew.simulator.battle.vg.snake;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.vg.slycooper.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.snake
 * 4/3/2020
 *
 * @author argen
 */
public class SolidSnake {

    public static final String NAME = "Solid Snake";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.1);
        defenses.set(AttackSubType.HANDGUN, 0.9);
        defenses.set(AttackSubType.RIFLE, 0.9);
        defenses.set(AttackSubType.SHOTGUN, 0.9);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.1);

        FighterStats stats = FighterStats.builder().strength(6).toughness(7).dexterity(6).aim(7)
                .agility(5).speed(4.5).intellect(7.5).willpower(4).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter with tactics that make some attacks difficult to defend.")
                .entryQuotes(Arrays.asList("Snake: 'Kept you waiting, huh?'",
                        "Snake: 'He who controls the battlefield, controls history.'"))
                .victoryQuotes(Arrays.asList("Snake: 'I’m no hero. Never was, never will be.'",
                        "Snake: 'Colonel, mission accomplished.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new M67FragGrenade()).addAction(new MK23SOCOM()).addAction(new FAMAS())
                .addAction(new StealthTakedown()).addAction(new StunKnife())
                .addAction(new M79GrenadeLauncher())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
