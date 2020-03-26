package com.argentstew.simulator.battle.vg.ness;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.DragonSlayer;
import com.argentstew.simulator.battle.vg.marth.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ness
 * 8/27/2019
 *
 * @author Craig
 */
public class Ness {

    public static final String NAME = "Ness";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.MYSTIC, 1.1);
        defenses.set(AttackSubType.THUNDER, 1.1);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(5).dexterity(7).aim(5.5)
                .agility(5).speed(5).intellect(5).willpower(7).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new DragonSlayer()));
        return Fighter.builder().name(NAME).hp(135).maxHp(135).mp(120).maxMp(120).xStrikeMeter(0)
                .entryQuotes(Arrays.asList("Ness pulls out his bat and does a home run pose.",
                        "Ness explodes onto the scene, ready for battle!"))
                .victoryQuotes(Arrays.asList("Ness nods solemnly, acknowledging his victory in battle.",
                        "Ness tips his cap with a smile in victory."))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new CaseyBat()).addAction(new CombatYoyo()).addAction(new PkRockinAlpha())
                .addAction(new PkRockinBeta())
                .addAction(new PsiShieldAlpha()).addAction(new PsiShieldBeta())
                .addAction(new PkStarstorm())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
