package com.argentstew.simulator.battle.vg.drwily;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.MechRider;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.megaman.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.drwily
 * 3/27/2020
 *
 * @author argen
 */
public class DrWily {

    public static final String NAME = "Dr. Wily";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.PUNCH, 1.1);
        defenses.set(AttackSubType.FIRE, 1.15);
        defenses.set(AttackSubType.WATER, 1.1);
        defenses.set(AttackSubType.PLASMA, 1.05);
        defenses.set(AttackSubType.HANDGUN, 0.8);
        defenses.set(AttackSubType.RIFLE, 0.8);
        defenses.set(AttackSubType.SHOTGUN, 0.8);
        defenses.set(AttackSubType.EXPLOSIVE, 1.1);

        FighterStats stats = FighterStats.builder().strength(7).toughness(7).dexterity(5.5).aim(5)
                .agility(2).speed(2).intellect(9).willpower(4).size(8).weight(9).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new MechRider()));
        return Fighter.builder().name(NAME).hp(190).maxHp(190).xStrikeMeter(0)
                .description("A mech-riding tank that calls on his Robot Masters to assist in his X-Strike.")
                .entryQuotes(Arrays.asList("Dr. Wily: 'The name's Wily... The one and only, the brilliant scientist, Dr. Wily!'",
                        "Dr. Wily: 'I'll defeat you and conquer the world!'"))
                .victoryQuotes(Arrays.asList("Dr. Wily: 'I didn't think you'd make it this far! However, I don't have time to deal with you! Say goodnight!'",
                        "Dr. Wily: 'This is just the beginning! Genius prevails! Wily always wins!'"))
                .classifications(Arrays.asList(FighterClassification.MECH, FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new DefensiveStrategy()).build()
                .addAction(new EnergyPulse()).addAction(new ElementalOrbs()).addAction(new WilyPress())
                .addAction(new Wm7Miniature()).addAction(new CamouflageCloak())
                .addAction(new RobotMasterAssault())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
