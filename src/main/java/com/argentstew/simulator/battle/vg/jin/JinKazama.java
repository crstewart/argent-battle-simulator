package com.argentstew.simulator.battle.vg.jin;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.ComboStrike;
import com.argentstew.simulator.battle.trait.impl.StealthDetection;
import com.argentstew.simulator.battle.trait.impl.Teleportation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * com.argentstew.simulator.battle.vg.jin
 * 4/4/2020
 *
 * @author argen
 */
public class JinKazama {

    public static final String NAME = "Jin Kazama";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.PUNCH, 0.8);
        defenses.set(AttackSubType.KICK, 0.8);
        defenses.set(AttackSubType.HEADBUTT, 0.8);
        defenses.set(AttackSubType.SLAM, 0.8);
        defenses.set(AttackSubType.GRAPPLE, 0.8);
        defenses.set(AttackSubType.FIRE, 0.7);
        defenses.set(AttackSubType.THUNDER, 0.7);
        defenses.set(AttackSubType.AIR, 1.25);
        defenses.set(AttackSubType.CHI, 1.4);
        defenses.set(AttackSubType.LIGHT, 1.5);
        defenses.set(AttackSubType.MYSTIC, 1.25);
        defenses.set(AttackSubType.GRAVITY, 1.25);

        FighterStats stats = FighterStats.builder().strength(7).toughness(4).dexterity(6).aim(4.5)
                .agility(5.5).speed(6).intellect(4).willpower(3).size(5).weight(5).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new ComboStrike(), new Teleportation(), new StealthDetection()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A brawler who switches between human and demon when using certain attacks.")
                .entryQuotes(Arrays.asList("Jin: 'Don't get in my way.'", "Jin: 'Power is everything!'"))
                .victoryQuotes(Arrays.asList("Jin: 'I am Jin Kazama, head of the Mishima Zaibatsu. I have a duty.'",
                        "Jin: 'My mother tried to keep me from Tekken... Now I know why. Tekken is fear!'"))
                .classifications(new ArrayList<FighterClassification>() {{ add(FighterClassification.HUMANOID); }})
                .defenses(defenses).stats(stats).traits(traits)
                .strategy(new BalancedStrategy()).build()
                .addAction(new ElectricWindGodFist()).addAction(new Stonehead()).addAction(new RageDrive())
                .addAction(new DevilBeam()).addAction(new PenetratingFist())
                .addAction(new DevilLaserCannon())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
