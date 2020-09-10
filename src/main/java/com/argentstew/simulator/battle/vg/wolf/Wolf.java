package com.argentstew.simulator.battle.vg.wolf;

import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.fox
 * 8/26/2019
 *
 * @author Craig
 */
public class Wolf {

    public static final String NAME = "Wolf O'Donnell";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.3);

        FighterStats stats = FighterStats.builder().strength(6).toughness(7.5).dexterity(7.5).aim(7.5)
                .agility(5).speed(5.5).intellect(5).willpower(5).size(4.5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new StealthDetection()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A strong, tough fighter with a reflective guard.")
                .entryQuotes(Arrays.asList("Wolf: 'Don't get too cocky!'", "Wolf: 'Playtime's over!'"))
                .victoryQuotes(Arrays.asList("Wolf: 'Don't hesitate! When the time comes, just act!'",
                        "Wolf: 'Weaklings, the bunch of you!'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new Blaster()).addAction(new WolfClaw()).addAction(new WolfFlash())
                .addAction(new WolfKick()).addAction(new Reflector())
                .addAction(new WolfenAssault())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
