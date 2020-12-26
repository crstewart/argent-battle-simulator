package com.argentstew.simulator.battle.vg.ryu;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.MeleeStrategy;
import com.argentstew.simulator.battle.trait.impl.ComboStrike;
import com.argentstew.simulator.battle.trait.impl.MechRider;
import com.argentstew.simulator.battle.vg.tronbonne.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ryu
 * 3/28/2020
 *
 * @author argen
 */
public class Ryu {

    public static final String NAME = "Ryu";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.75);
        defenses.set(AttackSubType.KICK, 0.75);
        defenses.set(AttackSubType.HEADBUTT, 0.75);
        defenses.set(AttackSubType.SLAM, 0.75);
        defenses.set(AttackSubType.GRAPPLE, 0.75);
        defenses.set(AttackSubType.CHI, 0.75);
        defenses.set(AttackSubType.DARK, 1.3);

        FighterStats stats = FighterStats.builder().strength(6).toughness(5.5).dexterity(5).aim(5)
                .agility(4.5).speed(4.5).intellect(4.5).willpower(6).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new ComboStrike()));
        return Fighter.builder().name(NAME).hp(150).maxHp(150).xStrikeMeter(0)
                .description("An all-around fighter with experience against other hand-to-hand combatants.")
                .entryQuotes(Arrays.asList("Ryu: 'The answer lies in the heart of battle.'",
                        "Ryu: 'Show me your strength.'"))
                .victoryQuotes(Arrays.asList("Ryu: 'You must defeat Sheng Long to stand a chance.'",
                        "Ryu: 'This was a battle of spirits, not fists. Search your soul if you want to beat me!'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Hadouken()).addAction(new Shoryuken()).addAction(new TatsumakiSenpukyaku())
                .addAction(new CollarboneBreaker()).addAction(new JoudanSokutigeri())
                .addAction(new ShinkuHadouken())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
