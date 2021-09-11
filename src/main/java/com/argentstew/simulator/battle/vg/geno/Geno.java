package com.argentstew.simulator.battle.vg.geno;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.geno
 * 3/26/2020
 *
 * @author argen
 */
public class Geno {

    public static final String NAME = "Geno";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.FIRE, 1.2);
        defenses.set(AttackSubType.NATURE, 0.7);
        defenses.set(AttackType.MELEE, 1.2);
        defenses.set(AttackType.RANGED, 1.2);
        defenses.set(AttackType.MAGIC, 1.4);
        defenses.set(AttackSubType.GRAVITY, 0.85);

        FighterStats stats = FighterStats.builder().strength(7).toughness(5).dexterity(6.5).aim(7.5)
                .agility(6).speed(6.5).intellect(6).willpower(8).size(4).weight(3.5).build();
        FighterTraits traits = new FighterTraits(Collections.emptyList());
        return Fighter.builder().name(NAME).hp(130).maxHp(130).mp(50).maxMp(50).xStrikeMeter(0)
                .description("A weaponmaster with weak defenses whose attacks vary in speed and power.")
                .entryQuotes(Arrays.asList("Geno: 'I serve... a higher authority...'",
                        "Geno: 'Come on! Let's get this show on the road.'"))
                .victoryQuotes(Arrays.asList("Geno: 'Well, we won the battle. Now I hope we don't lose the war.'",
                        "Geno: 'This is how it used to be, but now... it's like... THIS! Do you get it?'"))
                .classifications(Collections.singletonList(FighterClassification.DIVINE))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new GenoBeam()).addAction(new GenoWhirl()).addAction(new GenoBlast())
                .addAction(new RocketPunch()).addAction(new StarGun()).addAction(new GenoBoost())
                .addAction(new GenoFlash())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
