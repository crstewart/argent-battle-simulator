package com.argentstew.simulator.battle.vg.masterchief;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.vg.gordonfreeman.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.masterchief
 * 4/4/2020
 *
 * @author argen
 */
public class MasterChief {

    public static final String NAME = "Master Chief";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.2);
        defenses.set(AttackSubType.PLASMA, 1.1);
        defenses.set(AttackSubType.SLASH, 1.05);
        defenses.set(AttackSubType.HANDGUN, 0.85);
        defenses.set(AttackSubType.RIFLE, 0.9);
        defenses.set(AttackSubType.SHOTGUN, 0.95);
        defenses.set(AttackSubType.EXPLOSIVE, 0.9);
        defenses.set(AttackSubType.ARMOR_PIERCING, 0.9);

        FighterStats stats = FighterStats.builder().strength(7).toughness(7).dexterity(5.5).aim(7)
                .agility(3.5).speed(3).intellect(6).willpower(5).size(5).weight(5.5).build();
        FighterTraits traits = new FighterTraits();
        return Fighter.builder().name(NAME).hp(170).maxHp(170).xStrikeMeter(0)
                .description("A futuristic tank who can pierce enemy armor with a charged attack.")
                .entryQuotes(Arrays.asList("Master Chief: 'Don't get any funny ideas.'",
                        "Master Chief: 'I was gonna shoot my way out of this. Mix things up a little.'"))
                .victoryQuotes(Arrays.asList("Master Chief: 'I think we're just getting started.'",
                        "Master Chief: 'You know me. When I keep a promise...'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new Crowbar()).addAction(new SPAS12()).addAction(new OverwatchPulseRifle())
                .addAction(new GravityGun()).addAction(new SuitCharge())
                .addAction(new TauCannon())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
