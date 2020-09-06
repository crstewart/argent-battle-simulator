package com.argentstew.simulator.battle.vg.tronbonne;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.DefensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.MechRider;
import com.argentstew.simulator.battle.vg.drwily.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.tronbonne
 * 3/27/2020
 *
 * @author argen
 */
public class TronBonne {

    public static final String NAME = "Tron Bonne";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.PUNCH, 1.2);
        defenses.set(AttackSubType.KICK, 1.1);
        defenses.set(AttackSubType.PLASMA, 1.2);
        defenses.set(AttackSubType.HANDGUN, 0.8);
        defenses.set(AttackSubType.RIFLE, 0.8);
        defenses.set(AttackSubType.SHOTGUN, 0.8);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.5);

        FighterStats stats = FighterStats.builder().strength(7.5).toughness(4).dexterity(4).aim(5)
                .agility(3).speed(2.5).intellect(8.5).willpower(6).size(6).weight(7).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new MechRider()));
        return Fighter.builder().name(NAME).hp(180).maxHp(180).xStrikeMeter(0)
                .description("A mech-riding tank with an army of Servbots at her side.")
                .entryQuotes(Arrays.asList("Tron: 'Give me all your valuables and leave!'",
                        "Tron: 'I would give up now if I were you!'"))
                .victoryQuotes(Arrays.asList("Tron: 'The Bonne Family, air pirates at large, are here to relieve you of all your valuables!'",
                        "Tron: 'Tron Bonne, Queen of the Servbots, at your service!'"))
                .classifications(Arrays.asList(FighterClassification.MECH, FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ServbotLauncher()).addAction(new BanditBoulder()).addAction(new GustaffFire())
                .addAction(new BonneStrike()).addAction(new GustaffShield())
                .addAction(new KingServbot())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
