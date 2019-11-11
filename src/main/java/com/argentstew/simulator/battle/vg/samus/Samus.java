package com.argentstew.simulator.battle.vg.samus;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.BountyHunter;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.vg.pikachu.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.samus
 * 9/7/2019
 *
 * @author Craig
 */
public class Samus {

    public static final String NAME = "Samus Aran";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.25);
        defenses.set(AttackSubType.HANDGUN, 0.75);
        defenses.set(AttackSubType.SHOTGUN, 0.75);
        defenses.set(AttackSubType.RIFLE, 0.75);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.1);

        FighterStats stats = FighterStats.builder().strength(6).toughness(6).dexterity(5.5).aim(7)
                .agility(6).speed(4).intellect(5).willpower(4.5).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new BountyHunter()));
        return Fighter.builder().name(NAME).hp(130).maxHp(130).mp(10).maxMp(10).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Samus: 'You're mine!'", "Samus: 'Try me.'"))
                .victoryQuotes(Arrays.asList("Samus: 'My past is not a memory. It's a force at my back.'",
                        "Samus: 'Is that all?'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ChargeBeam()).addAction(new ChargeBeamFull()).addAction(new Missile())
                .addAction(new SuperMissile()).addAction(new WaveBeam()).addAction(new IceBeam())
                .addAction(new ScrewAttack())
                .addAction(new ZeroLaser())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
