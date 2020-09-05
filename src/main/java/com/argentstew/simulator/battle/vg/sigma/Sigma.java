package com.argentstew.simulator.battle.vg.sigma;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.ExMaverickHunter;
import com.argentstew.simulator.battle.vg.zelda.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.sigma
 * 3/27/2020
 *
 * @author argen
 */
public class Sigma {

    public static final String NAME = "Sigma";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.5);
        defenses.set(AttackSubType.SLASH, 1.25);
        defenses.set(AttackSubType.THUNDER, 1.25);
        defenses.set(AttackSubType.SOUND, 1.2);
        defenses.set(AttackSubType.HANDGUN, 0.7);
        defenses.set(AttackSubType.RIFLE, 0.7);
        defenses.set(AttackSubType.SHOTGUN, 0.7);

        FighterStats stats = FighterStats.builder().strength(7).toughness(6.5).dexterity(6).aim(6)
                .agility(6).speed(6.5).intellect(7).willpower(3).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new ExMaverickHunter()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A weaponmaster with high stats and an affinity for fighting mechs.")
                .entryQuotes(Arrays.asList("Sigma: 'You shall regret ever having defied me!'",
                        "Sigma: 'It is about time that I crush you beneath my heel!'"))
                .victoryQuotes(Arrays.asList("Sigma: 'Nice try! But you're just a tiny bug to me! Ha ha ha ha...'",
                        "Sigma: 'Bwah ha ha ha. Your efforts are futile... I will never be defeated!'"))
                .classifications(Collections.singletonList(FighterClassification.MECH))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new BeamSaber()).addAction(new NeoClaws()).addAction(new ReaperScythe())
                .addAction(new DoomBuster())
                .addAction(new SigmaVirus())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
