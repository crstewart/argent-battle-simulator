package com.argentstew.simulator.battle.vg.ezio;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.rayman.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ezio
 * 4/4/2020
 *
 * @author argen
 */
public class Ezio {

    public static final String NAME = "Ezio Auditore";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.95);
        defenses.set(AttackSubType.PLASMA, 1.05);

        FighterStats stats = FighterStats.builder().strength(5).toughness(5).dexterity(8).aim(7.5)
                .agility(5.5).speed(5).intellect(5.5).willpower(5).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("A Renaissance weaponmaster whose strikes have increased critical hit chance.")
                .entryQuotes(Arrays.asList("Ezio: 'Nothing is true. Everything is permitted.'",
                        "Ezio: 'My story is one of many thousands, and the world will not suffer if it ends too soon.'"))
                .victoryQuotes(Arrays.asList("Ezio: 'Requiescat in pace.'",
                        "Ezio: 'We must never give up the fight. The minute we do that, we have lost.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new SwordOfAltair()).addAction(new FlangedMace()).addAction(new Crossbow())
                .addAction(new HiddenGun())
                .addAction(new AssassinsBlades())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
