package com.argentstew.simulator.battle.vg.pit;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.BountyHunter;
import com.argentstew.simulator.battle.trait.impl.GodSlayer;
import com.argentstew.simulator.battle.vg.captfalcon.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.pit
 * 3/26/2020
 *
 * @author argen
 */
public class Pit {

    public static final String NAME = "Pit";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 0.8);
        defenses.set(AttackSubType.LIGHT, 0.7);
        defenses.set(AttackSubType.DARK, 0.7);

        FighterStats stats = FighterStats.builder().strength(4).toughness(3).dexterity(7.5).aim(8.5)
                .agility(6.5).speed(4.5).intellect(3).willpower(6).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new GodSlayer()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A weaponmaster with resistances to light and dark magic.")
                .entryQuotes(Arrays.asList("Pit: 'Sorry to keep you waiting!'",
                        "Pit: 'I hope you're ready for a hot plate of punishment!'"))
                .victoryQuotes(Arrays.asList("Pit: 'Gracious goddess of light watches from up above!'",
                        "Pit: 'It's game over for you!'"))
                .classifications(Collections.singletonList(FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new PalutenaBow()).addAction(new UpperdashArm()).addAction(new FirstBlade())
                .addAction(new InsightStaff()).addAction(new OreClub()).addAction(new GuardianOrbitars())
                .addAction(new ThreeSacredTreasures())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
