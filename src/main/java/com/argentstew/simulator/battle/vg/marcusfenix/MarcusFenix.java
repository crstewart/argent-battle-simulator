package com.argentstew.simulator.battle.vg.marcusfenix;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.masterchief.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.marcusfenix
 * 4/4/2020
 *
 * @author argen
 */
public class MarcusFenix {

    public static final String NAME = "Marcus Fenix";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.SLASH, 0.9);
        defenses.set(AttackSubType.PIERCE, 0.9);
        defenses.set(AttackSubType.HACK, 0.9);
        defenses.set(AttackSubType.SMASH, 1.1);
        defenses.set(AttackSubType.HANDGUN, 0.9);
        defenses.set(AttackSubType.RIFLE, 0.95);
        defenses.set(AttackSubType.SHOTGUN, 0.95);
        defenses.set(AttackSubType.HEADBUTT, 1.05);
        defenses.set(AttackSubType.TAIL, 0.95);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.1);
        defenses.set(AttackSubType.ASSIST, 0.95);

        FighterStats stats = FighterStats.builder().strength(6).toughness(6.5).dexterity(6).aim(8)
                .agility(4).speed(4).intellect(5).willpower(6).size(5).weight(5.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A futuristic weaponmaster who is heavily armored.")
                .entryQuotes(Arrays.asList("Marcus: 'Well, I'm not here to sell cookies... So they know something's up.'",
                        "Marcus: 'Looks to me like you need all the help you can get.'"))
                .victoryQuotes(Arrays.asList("Marcus: 'I'm no saint. But I am gonna win this war.'",
                        "Marcus: 'I came here to help you, and that's what I'm gonna do.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Mk2Lancer()).addAction(new LancerChainsaw()).addAction(new Gnasher())
                .addAction(new Mortar()).addAction(new BoomShield())
                .addAction(new HammerOfDawn())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
