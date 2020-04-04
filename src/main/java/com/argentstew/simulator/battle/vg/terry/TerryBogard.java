package com.argentstew.simulator.battle.vg.terry;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.vg.bigdaddy.Charge;
import com.argentstew.simulator.battle.vg.bigdaddy.DrillPunch;
import com.argentstew.simulator.battle.vg.bigdaddy.DrillSlam;
import com.argentstew.simulator.battle.vg.bigdaddy.EnragedFrenzy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.terry
 * 4/4/2020
 *
 * @author argen
 */
public class TerryBogard {

    public static final String NAME = "Terry Bogard";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.9);
        defenses.set(AttackSubType.KICK, 0.9);
        defenses.set(AttackSubType.HEADBUTT, 0.9);
        defenses.set(AttackSubType.SLAM, 0.9);
        defenses.set(AttackSubType.GRAPPLE, 0.9);
        defenses.set(AttackSubType.CHI, 0.8);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(6).dexterity(6).aim(5.5)
                .agility(6.5).speed(5.5).intellect(4.5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter who uses special moves when his HP runs low.")
                .entryQuotes(Arrays.asList("Terry: 'I have too much power, get ready to be hurt!'",
                        "Terry: 'Hey, c'mon, c'mon!'"))
                .victoryQuotes(Arrays.asList("Terry: 'Did you think you could beat me! Go home!'",
                        "Terry: 'Okay! Piece of cake!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new TerryStrategy()).build()
                .addAction(new PowerWave()).addAction(new BurningKnuckle()).addAction(new CrackShoot())
                .addAction(new PowerDunk()).addAction(new BusterWolf()).addAction(new PowerGeyser())
                .addAction(new TripleWolf())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
