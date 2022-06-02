package com.argentstew.simulator.battle.vg.ellie;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.RangedStrategy;
import com.argentstew.simulator.battle.trait.impl.Survivalist;
import com.argentstew.simulator.battle.trait.impl.ZombieSlayer;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ellie
 * 3/27/2020
 *
 * @author argen
 */
public class Ellie {

    public static final String NAME = "Ellie";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.GRAVITY, 0.95);

        FighterStats stats = FighterStats.builder().strength(4.5).toughness(5).dexterity(6).aim(6.5)
                .agility(5).speed(4.5).intellect(5.5).willpower(8).size(4.5).weight(4.5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new ZombieSlayer(), new Survivalist()));
        return Fighter.builder().name(NAME).hp(140).maxHp(140).xStrikeMeter(0)
                .description("A survivalist weaponmaster with experience fighting against the undead.")
                .entryQuotes(Arrays.asList("Ellie: 'Everyone I have cared for has either died or left me.'",
                        "Ellie: 'I can make it quick... or I can make it so much worse.'"))
                .victoryQuotes(Arrays.asList("Ellie: 'We're not murderers. We just survive.'",
                        "Ellie: 'To the edge of the universe and back. Endure and survive.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new RangedStrategy()).build()
                .addAction(new Bow()).addAction(new Pistol()).addAction(new PumpShotgun())
                .addAction(new SemiAutomaticRifle()).addAction(new MedKit())
                .addAction(new SilencedSubmachineGun())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
