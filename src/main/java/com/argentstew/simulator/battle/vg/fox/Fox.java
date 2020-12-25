package com.argentstew.simulator.battle.vg.fox;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;
import com.argentstew.simulator.battle.vg.bowser.Bowser;
import com.argentstew.simulator.battle.vg.mario.*;
import com.argentstew.simulator.battle.vg.wolf.Wolf;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.fox
 * 8/26/2019
 *
 * @author Craig
 */
public class Fox {

    public static final String NAME = "Fox McCloud";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(5.5).dexterity(8.5).aim(8.5)
                .agility(6.5).speed(6.5).intellect(6).willpower(6).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new StealthDetection(), new Rival(Wolf.NAME, 1.3)));
        return Fighter.builder().name(NAME).hp(135).maxHp(135).xStrikeMeter(0)
                .description("A weaponmaster with a reflective guard and a blaster that does not stun opponents.")
                .entryQuotes(Arrays.asList("Fox: 'Here I come!'", "Fox: 'Star Fox, ready for duty!'"))
                .victoryQuotes(Arrays.asList("Fox: 'This is Fox, returning to base!'",
                        "Fox: 'Sorry to jet, but I'm in a hurry!'"))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.ANIMAL))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new Blaster()).addAction(new GatlingGun()).addAction(new FoxIllusion())
                .addAction(new FireFox()).addAction(new Reflector())
                .addAction(new ArwingAssault())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
