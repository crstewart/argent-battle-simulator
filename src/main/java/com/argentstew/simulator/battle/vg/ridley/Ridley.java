package com.argentstew.simulator.battle.vg.ridley;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.AttackType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.NaturalAgility;
import com.argentstew.simulator.battle.vg.mewtwo.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.ridley
 * 9/15/2019
 *
 * @author Craig
 */
public class Ridley {

    public static final String NAME = "Ridley";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackType.MAGIC, 1.4);
        defenses.set(AttackSubType.PUNCH, 1.2);
        defenses.set(AttackSubType.KICK, 0.8);
        defenses.set(AttackSubType.WING, 0.8);
        defenses.set(AttackSubType.TAIL, 0.8);
        defenses.set(AttackSubType.AIR, 1.2);
        defenses.set(AttackSubType.ICE, 1.3);
        defenses.set(AttackSubType.PLASMA, 1.25);
        defenses.set(AttackSubType.HANDGUN, 0.8);
        defenses.set(AttackSubType.SHOTGUN, 0.8);
        defenses.set(AttackSubType.RIFLE, 0.8);
        defenses.set(AttackSubType.EXPLOSIVE, 1.25);
        defenses.set(AttackSubType.GRAVITY, 0.7);

        FighterStats stats = FighterStats.builder().strength(7.5).toughness(5.5).dexterity(5).aim(5)
                .agility(8).speed(8).intellect(6).willpower(3).size(9).weight(8).build();
        FighterTraits traits = new FighterTraits(Collections.singletonList(new NaturalAgility()));
        return Fighter.builder().name(NAME).hp(180).maxHp(180).xStrikeMeter(0)
                .description("A brawler with high speed and power whose tail can strike critically.")
                .entryQuotes(Arrays.asList("Ridley swoops into the battlefield with a flap of his wings.'",
                        "Ridley roars and prepares himself for the coming battle.'"))
                .victoryQuotes(Arrays.asList("Ridley stands over his opponent, triumphant.'",
                        "Ridley picks up his fallen opponent and slams them into the ground.'"))
                .classifications(Arrays.asList(FighterClassification.ALIEN, FighterClassification.DRAGON))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new KineticBreath()).addAction(new SpacePirateRush()).addAction(new TailSkewer())
                .addAction(new WingBlitz())
                .addAction(new PlasmaScream())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat());
    }
}
