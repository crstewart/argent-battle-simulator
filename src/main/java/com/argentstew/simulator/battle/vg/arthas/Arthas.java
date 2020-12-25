package com.argentstew.simulator.battle.vg.arthas;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.jaina.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.arthas
 * 4/4/2020
 *
 * @author argen
 */
public class Arthas {

    public static final String NAME = "Arthas Menethil";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.6);
        defenses.set(AttackSubType.SLASH, 0.8);
        defenses.set(AttackSubType.PIERCE, 0.8);
        defenses.set(AttackSubType.HACK, 0.8);
        defenses.set(AttackSubType.SMASH, 1.2);
        defenses.set(AttackSubType.CLAW, 0.9);
        defenses.set(AttackSubType.BITE, 0.9);
        defenses.set(AttackSubType.PUNCH, 0.9);
        defenses.set(AttackSubType.KICK, 0.9);
        defenses.set(AttackSubType.HEADBUTT, 0.9);
        defenses.set(AttackSubType.DARK, 0.8);
        defenses.set(AttackSubType.LIGHT, 1.25);

        FighterStats stats = FighterStats.builder().strength(7).toughness(6.5).dexterity(6).aim(6.5)
                .agility(3).speed(3).intellect(5.5).willpower(7.5).size(5).weight(5.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(190).maxHp(190).xStrikeMeter(0)
                .description("A tank with strong anti-mage properties, including a magic guard.")
                .entryQuotes(Arrays.asList("Arthas: 'Frostmourne hungers.'", "Arthas: 'You shall know endless torment.'"))
                .victoryQuotes(Arrays.asList("Arthas: 'I intend to scour humanity from this planet, and make no mistake: I have the power to do it.'",
                        "Arthas: 'I will show you the justice of the grave...and the true meaning of fear.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Frostmourne()).addAction(new DeathCoil()).addAction(new HowlingBlast())
                .addAction(new NecroticPlague()).addAction(new AntiMagicShell())
                .addAction(new ArmyOfTheDead())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
