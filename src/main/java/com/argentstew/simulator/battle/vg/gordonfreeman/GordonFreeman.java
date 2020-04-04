package com.argentstew.simulator.battle.vg.gordonfreeman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.lloyd.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.gordonfreeman
 * 4/4/2020
 *
 * @author argen
 */
public class GordonFreeman {

    public static final String NAME = "Gordon Freeman";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.1);
        defenses.set(AttackSubType.SMASH, 1.1);
        defenses.set(AttackSubType.TOXIC, 0.95);
        defenses.set(AttackSubType.HANDGUN, 0.9);
        defenses.set(AttackSubType.RIFLE, 0.9);
        defenses.set(AttackSubType.SHOTGUN, 0.9);
        defenses.set(AttackSubType.EXPLOSIVE, 0.9);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.1);

        FighterStats stats = FighterStats.builder().strength(5).toughness(4.5).dexterity(7).aim(7.5)
                .agility(4.5).speed(4.5).intellect(6.5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A futuristic gunner who can charge his suit to reduce damage done to him.")
                .entryQuotes(Arrays.asList("Gordon walks onto the battlefield, crowbar at his side.",
                        "Gordon checks his weapon capacities to ensure he's ready for battle."))
                .victoryQuotes(Arrays.asList("Gordon nods and raises his weapon onto his shoulder.",
                        "Gordon lowers his weapon, looks at his fallen opponent, and nods."))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Crowbar()).addAction(new SPAS12()).addAction(new OverwatchPulseRifle())
                .addAction(new GravityGun()).addAction(new SuitCharge())
                .addAction(new TauCannon())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
