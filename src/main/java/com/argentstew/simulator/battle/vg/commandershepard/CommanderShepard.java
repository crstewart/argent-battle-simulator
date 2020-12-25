package com.argentstew.simulator.battle.vg.commandershepard;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.cole.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.commandershepard
 * 4/5/2020
 *
 * @author argen
 */
public class CommanderShepard {

    public static final String NAME = "Commander Shepard";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.5);
        defenses.set(AttackSubType.PUNCH, 0.8);
        defenses.set(AttackSubType.KICK, 0.8);
        defenses.set(AttackSubType.CLAW, 0.8);
        defenses.set(AttackSubType.BITE, 0.8);
        defenses.set(AttackSubType.TAIL, 0.8);
        defenses.set(AttackSubType.SLASH, 0.8);
        defenses.set(AttackSubType.PIERCE, 0.8);
        defenses.set(AttackSubType.HACK, 0.8);
        defenses.set(AttackSubType.SMASH, 0.8);
        defenses.set(AttackSubType.HANDGUN, 0.75);
        defenses.set(AttackSubType.RIFLE, 0.8);
        defenses.set(AttackSubType.SHOTGUN, 0.75);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.5);

        FighterStats stats = FighterStats.builder().strength(5.5).toughness(5.5).dexterity(5).aim(5)
                .agility(3).speed(2.5).intellect(5).willpower(3).size(5).weight(5.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(180).maxHp(180).xStrikeMeter(0)
                .description("A futuristic tank who uses a variety of ammo types in their guns.")
                .entryQuotes(Arrays.asList("Shepard: 'My name is Shepard, and I don’t take threats lightly.'",
                        "Shepard: 'Get out of my way.'"))
                .victoryQuotes(Arrays.asList("Shepard: 'Humans are aggressive. Wars have started because of our need for constant progress.'",
                        "Shepard: 'No matter how strong you are, allies make you stronger.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new M3Predator()).addAction(new M8Avenger()).addAction(new M76Revenant())
                .addAction(new M22Eviscerator())
                .addAction(new M920Cain())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
