package com.argentstew.simulator.battle.vg.bowserjr;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.Hazardous;
import com.argentstew.simulator.battle.trait.impl.MechRider;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.bowserjr
 * 8/26/2019
 *
 * @author Craig
 */
public class BowserJr {

    public static final String NAME = "Bowser Jr.";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.FIRE, 1.2);
        defenses.set(AttackSubType.WATER, 1.2);
        defenses.set(AttackSubType.TOXIC, 0.75);

        FighterStats stats = FighterStats.builder().strength(3.5).toughness(4).dexterity(6).aim(6)
                .agility(5.5).speed(6).intellect(2).willpower(7.5).size(4).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new MechRider(), new Hazardous()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A mech-riding weaponmaster that can hurt melee attackers with his spiky shell.")
                .entryQuotes(Arrays.asList("Bowser Jr: 'I won't even need my dad's help to take care of you!'",
                        "Bowser Jr: 'I'm Bowser Jr., and you'll be losing to ME today!'"))
                .victoryQuotes(Arrays.asList("Bowser Jr: 'You're lucky I'm playing this game fair and square!'",
                        "Bowser Jr: 'Yeah, haha! Yeah!'"))
                .classifications(Arrays.asList(FighterClassification.ANIMAL, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ClownCannon()).addAction(new HammerWhack()).addAction(new Mechakoopa())
                .addAction(new KoopaShellToss()).addAction(new WhirlingFortress())
                .addAction(new ShadowMarioPaint())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
