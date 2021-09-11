package com.argentstew.simulator.battle.status;

import com.argentstew.simulator.battle.action.Action;
import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.DefenseAction;
import com.argentstew.simulator.battle.action.MoveAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.action.attack.MagicAttack;
import com.argentstew.simulator.battle.action.attack.MeleeAttack;
import com.argentstew.simulator.battle.fighter.FighterClassification;
import com.argentstew.simulator.battle.fighter.FighterStats;
import com.argentstew.simulator.battle.trait.impl.*;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.status
 * 9/9/2021
 *
 * @author argen
 */
@Getter
public enum StatusType {

    POISON("poisoned", AttackSubType.TOXIC, 5,
            fighter -> fighter.getClassifications().size() == 1 && fighter.getClassifications().contains(FighterClassification.MECH)),
    BURN("burned", AttackSubType.FIRE, 4, fighter -> fighter.getTraits().has(HeatResistance.class)),
    PARALYSIS("paralyzed", FighterStats.SPEED, 0.5, fighter -> fighter.getTraits().has(NaturalAgility.class)),
    SLEEP("asleep", Arrays.asList(AttackAction.class, DefenseAction.class, MoveAction.class), fighter -> fighter.getTraits().has(Insomniac.class)),
    ROOT("rooted", Arrays.asList(MeleeAttack.class, MoveAction.class), fighter -> fighter.getTraits().has(Teleportation.class)),
    SLOW("slowed", 1, fighter -> fighter.getTraits().has(TimeManipulation.class)),
    SILENCE("silenced", Collections.singletonList(MagicAttack.class), fighter -> true),
    FROSTBITE("frostbitten", FighterStats.AGILITY, 0.5, fighter -> fighter.getTraits().has(ColdResistance.class));

    private final String logName;
    private final AttackSubType dotType;
    private final int dotDamage;
    private final String statEffected;
    private final double statMultiplier;
    private final double priorityChange;
    private final List<Class<? extends Action>> blockedActionTypes;
    private final StatusFunction effectCheck;

    StatusType(String logName, String statEffected, double statMultiplier, StatusFunction effectCheck) {
        this(logName, null, 0, statEffected, statMultiplier, 0, Collections.emptyList(), effectCheck);
    }

    StatusType(String logName, AttackSubType dotType, int dotDamage, StatusFunction effectCheck) {
        this(logName, dotType, dotDamage, null, 1.0, 0, Collections.emptyList(), effectCheck);
    }

    StatusType(String logName, List<Class<? extends Action>> blockedActionTypes, StatusFunction effectCheck) {
        this(logName, null, 0, null, 1.0, 0, blockedActionTypes, effectCheck);
    }

    StatusType(String logName, double priorityChange, StatusFunction effectCheck) {
        this(logName, null, 0, null, 1.0, priorityChange, Collections.emptyList(), effectCheck);
    }

    StatusType(String logName, AttackSubType dotType, int dotDamage, String statEffected,
               double statMultiplier, double priorityChange, List<Class<? extends Action>> blockedActionTypes,
               StatusFunction effectCheck) {
        this.logName = logName;
        this.dotType = dotType;
        this.dotDamage = dotDamage;
        this.statEffected = statEffected;
        this.statMultiplier = statMultiplier;
        this.priorityChange = priorityChange;
        this.blockedActionTypes = blockedActionTypes;
        this.effectCheck = effectCheck;
    }

    public boolean disallowsAction(Action action) {
        return blockedActionTypes.stream().anyMatch(clazz -> clazz.isInstance(action));
    }

    public boolean canBeOverwritten() {
        return blockedActionTypes == null || blockedActionTypes.isEmpty();
    }
}
