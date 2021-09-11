package com.argentstew.simulator.battle.vg.bubnbob;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.BuddySystem;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bubnbob
 * 4/1/2020
 *
 * @author argen
 */
public class BubAndBob {

    public static final String NAME = "Bub & Bob";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.FIRE, 0.75);
        defenses.set(AttackSubType.WATER, 0.75);
        defenses.set(AttackSubType.GRAVITY, 0.75);

        FighterStats stats = FighterStats.builder().strength(3).toughness(2).dexterity(5).aim(7)
                .agility(4).speed(3).intellect(4).willpower(4).size(3.5).weight(2.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new BuddySystem()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around dragon duo that fights better together than alone.")
                .entryQuotes(Arrays.asList("Narrator: 'Now it is the beginning of a fantastic story!'",
                        "Bub and Bob float onto the field encased in bubbles and land together."))
                .victoryQuotes(Arrays.asList("Narrator: 'Congratulations!'",
                        "Bub and Bob wrap themselves in bubbles and fly off to their next encounter.'"))
                .classifications(Collections.singletonList(FighterClassification.DRAGON))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Bubble()).addAction(new FireBubble()).addAction(new WaterBubble())
                .addAction(new ThunderBubble())
                .addAction(new ChacknHeart()).addAction(new CrossOfWater())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
