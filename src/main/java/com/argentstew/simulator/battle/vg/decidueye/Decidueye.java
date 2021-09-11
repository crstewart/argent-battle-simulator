package com.argentstew.simulator.battle.vg.decidueye;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.Insomniac;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.decidueye
 * 9/8/2019
 *
 * @author Craig
 */
public class Decidueye {

    public static final String NAME = "Decidueye";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.5);
        defenses.set(AttackSubType.KICK, 0.5);
        defenses.set(AttackSubType.HEADBUTT, 0.25);
        defenses.set(AttackSubType.SLAM, 0.75);
        defenses.set(AttackSubType.BITE, 1.75);
        defenses.set(AttackSubType.WING, 2);
        defenses.set(AttackSubType.FIRE, 2);
        defenses.set(AttackSubType.WATER, 0.5);
        defenses.set(AttackSubType.AIR, 2);
        defenses.set(AttackSubType.EARTH, 0.5);
        defenses.set(AttackSubType.THUNDER, 0.5);
        defenses.set(AttackSubType.ICE, 2);
        defenses.set(AttackSubType.DARK, 2);
        defenses.set(AttackSubType.NATURE, 0.5);
        defenses.set(AttackSubType.CHI, 0.25);
        defenses.set(AttackSubType.GRAPPLE, 0.5);
        defenses.set(AttackSubType.GRAVITY, 1.05);

        FighterStats stats = FighterStats.builder().strength(6).toughness(4.5).dexterity(3.5).aim(9.5)
                .agility(5).speed(4).intellect(3.5).willpower(4).size(4.5).weight(3).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Insomniac()));
        return Fighter.builder().name(NAME).hp(155).maxHp(155).xStrikeMeter(0)
                .description("A weaponmaster with many weaknesses and resistances and an attack that roots opponents.")
                .entryQuotes(Arrays.asList("Decidueye: 'Swoosh!'", "Decidueye tightens its hood and focuses on its opponent."))
                .victoryQuotes(Arrays.asList("Decidueye spreads its wings and flies off.",
                        "Decidueye folds its wings and calms itself."))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SpiritShackle()).addAction(new LeafBlade()).addAction(new BraveBird())
                .addAction(new Synthesis())
                .addAction(new SinisterArrowRaid())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
