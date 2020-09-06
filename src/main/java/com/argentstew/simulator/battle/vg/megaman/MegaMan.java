package com.argentstew.simulator.battle.vg.megaman;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.RangedStrategy;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.drwily.DrWily;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.megaman
 * 3/27/2020
 *
 * @author argen
 */
public class MegaMan {

    public static final String NAME = "Mega Man";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.4);
        defenses.set(AttackSubType.PIERCE, 1.25);
        defenses.set(AttackSubType.THUNDER, 1.2);
        defenses.set(AttackSubType.ICE, 1.2);
        defenses.set(AttackSubType.WATER, 0.6);
        defenses.set(AttackSubType.TOXIC, 0.75);
        defenses.set(AttackSubType.HANDGUN, 0.6);
        defenses.set(AttackSubType.RIFLE, 0.6);
        defenses.set(AttackSubType.SHOTGUN, 0.6);
        defenses.set(AttackSubType.ARMOR_PIERCING, 0.6);

        FighterStats stats = FighterStats.builder().strength(5).toughness(2).dexterity(6).aim(8)
                .agility(3).speed(3.5).intellect(2).willpower(3).size(4.5).weight(5.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new Rival(DrWily.NAME, 1.3)));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A weaponmaster with a large arsenal of ranged attacks that deals extra damage to Dr. Wily.")
                .entryQuotes(Arrays.asList("Mega Man: 'I am more than a robot!'", "Mega Man: 'We don't have to fight!'"))
                .victoryQuotes(Arrays.asList("Mega Man: 'Could I really be as evil and violent as the man I oppose? I could have brought peace!'",
                        "Mega Man: 'Right on! Now, what new powers have I obtained?!'"))
                .classifications(Collections.singletonList(FighterClassification.MECH))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new PlasmaCannon()).addAction(new MegaBuster()).addAction(new SuperArm())
                .addAction(new MetalBlade()).addAction(new HardKnuckle()).addAction(new NapalmBomb())
                .addAction(new FlameBlast()).addAction(new SlashClaw()).addAction(new SkullBarrier())
                .addAction(new BlackHoleBomb())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
