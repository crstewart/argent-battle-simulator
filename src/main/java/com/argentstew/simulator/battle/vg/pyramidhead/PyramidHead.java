package com.argentstew.simulator.battle.vg.pyramidhead;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.OffensiveStrategy;
import com.argentstew.simulator.battle.trait.impl.EndlessTorment;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;

import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.pyramidhead
 * 8/27/2019
 *
 * @author Craig
 */
public class PyramidHead {

    public static final String NAME = "Pyramid Head";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.HEADBUTT, 0.6);
        defenses.set(AttackSubType.FIRE, 1.2);
        defenses.set(AttackSubType.DARK, 0.6);
        defenses.set(AttackSubType.MYSTIC, 0.7);

        FighterStats stats = FighterStats.builder().strength(7).toughness(7.5).dexterity(3).aim(1)
                .agility(2).speed(1.5).intellect(1).willpower(4).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new EndlessTorment(), new StealthDetection()));
        return Fighter.builder().name(NAME).hp(180).maxHp(180).xStrikeMeter(0)
                .description("A tank that torments its foes and prevents certain traits from activating.")
                .entryQuotes(Arrays.asList("Pyramid Head shambles into battle, dragging its huge knife on the ground.",
                        "Pyramid Head draws its spear and faces its opponent menacingly."))
                .victoryQuotes(Arrays.asList("Pyramid Head fades into the darkness.",
                        "Pyramid Head stands over its fallen foe, ready to inflict more torment."))
                .classifications(Arrays.asList(FighterClassification.HUMANOID, FighterClassification.MONSTER))
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new OffensiveStrategy()).build()
                .addAction(new GreatKnife()).addAction(new GreatSpear()).addAction(new ChokeHold())
                .addAction(new PunishmentOfTheDamned())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
