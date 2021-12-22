package com.argentstew.simulator.battle.vg.monsterhunter;

import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.defense.Dodge;
import com.argentstew.simulator.battle.action.move.Advance;
import com.argentstew.simulator.battle.action.move.Retreat;
import com.argentstew.simulator.battle.action.move.Sleep;
import com.argentstew.simulator.battle.fighter.*;
import com.argentstew.simulator.battle.strategy.BalancedStrategy;
import com.argentstew.simulator.battle.trait.impl.MonsterSlayer;
import com.argentstew.simulator.battle.trait.impl.Rival;
import com.argentstew.simulator.battle.vg.rathalos.Rathalos;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.argentstew.simulator.battle.vg.monsterhunter
 * 9/15/2019
 *
 * @author Craig
 */
public class MonsterHunter {

    public static final String NAME = "Monster Hunter";

    public static final String WEAPON_GREAT_SWORD = "Great Sword";
    public static final String WEAPON_GUNLANCE = "Gunlance";
    public static final String WEAPON_HAMMER = "Hammer";
    public static final String WEAPON_BOWGUN = "Bowgun";

    public static Fighter get() {
        FighterDefenses defenses = new FighterDefenses();
        defenses.set(AttackSubType.SLASH, 0.8);
        defenses.set(AttackSubType.HACK, 0.8);
        defenses.set(AttackSubType.SMASH, 0.8);
        defenses.set(AttackSubType.BITE, 0.7);
        defenses.set(AttackSubType.CLAW, 0.7);
        defenses.set(AttackSubType.TAIL, 0.7);
        defenses.set(AttackSubType.ARMOR_PIERCING, 1.5);
        defenses.set(AttackSubType.FIRE, 0.7);
        defenses.set(AttackSubType.THUNDER, 1.3);
        defenses.set(AttackSubType.MYSTIC, 1.3);
        defenses.set(AttackSubType.GRAVITY, 1.1);

        FighterStats stats = FighterStats.builder().strength(6).toughness(4).dexterity(8).aim(7)
                .agility(4).speed(4).intellect(5).willpower(5.5).size(5).weight(6).build();
        FighterTraits traits = new FighterTraits(Arrays.asList(new Rival(Rathalos.NAME, 1.3),
                new MonsterSlayer()));
        return Fighter.builder().name(NAME).hp(160).maxHp(160).xStrikeMeter(0)
                .description("A tanky weaponmaster with a variety of weapons at their disposal.")
                .entryQuotes(Arrays.asList("Monster Hunter: 'I've taken down bigger beasts than you!'",
                        "Monster Hunter: 'Is this a new quest?'"))
                .victoryQuotes(Arrays.asList("Monster Hunter: 'The goal of a Monster Hunter is to be in harmony with nature, not destroy it.'",
                        "Monster Hunter: 'People from across worlds are teaming up and hunting together. That kind of partnership deserves to be protected.'"))
                .classifications(Collections.singletonList(FighterClassification.HUMANOID))
                .defenses(defenses).stats(stats).traits(traits).selfStatus(WEAPON_GREAT_SWORD)
                .strategy(new BalancedStrategy()).build()
                .addAction(new GreatSword()).addAction(new Lance()).addAction(new Hammer())
                .addAction(new Bow()).addAction(new Artillery()).addAction(new ShockTrap()).addAction(new TranqBomb())
                .addAction(new HuntersPride())
                .addAction(new Dodge()).addAction(new Advance()).addAction(new Retreat()).addAction(new Sleep());
    }
}
