package com.argentstew.simulator.battle.vg.shaokahn;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.shaokahn
 * 4/6/2020
 *
 * @author argen
 */
public class ShaoKahn {

    public static final String NAME = "Shao Kahn";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.8);
        defenses.set(AttackSubType.KICK, 0.8);
        defenses.set(AttackSubType.SLAM, 0.8);
        defenses.set(AttackSubType.GRAPPLE, 0.8);
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.SLASH, 0.8);
        defenses.set(AttackSubType.PIERCE, 0.8);
        defenses.set(AttackSubType.SMASH, 0.8);
        defenses.set(AttackSubType.HACK, 0.8);

        FighterStats stats = FighterStats.builder().strength(7).toughness(7.5).dexterity(6).aim(6)
                .agility(4.5).speed(4).intellect(6).willpower(7).size(5.5).weight(5.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).mp(40).maxMp(40).xStrikeMeter(0)
                .description("A powerful brawler who sometimes stops attacking to ridicule his opponents.")
                .entryQuotes(Arrays.asList("Shao Kahn: 'I am Shao Kahn! And you will bow to me!'",
                        "Shao Kahn: 'Feel the wrath of Shao Kahn!'"))
                .victoryQuotes(Arrays.asList("Shao Kahn: 'The Elder Gods fear me, now.'",
                        "Shao Kahn: 'Why waste tears on weaklings?'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new ShaoKahnStrategy()).build()
                .addAction(new WrathHammer()).addAction(new MercilessSpear()).addAction(new ChargingSpikes())
                .addAction(new ExplosiveBall()).addAction(new Ridicule())
                .addAction(new HomeRun())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
