package com.argentstew.simulator.battle.action;

import com.argentstew.simulator.battle.action.attack.AttackCharacteristic;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * com.argentstew.simulator.battle.action
 * 8/17/2019
 *
 * @author Craig
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class AttackAction extends Action {

    private String name;
    private int power;
    private double variance;
    private int speed;
    private double stunChance;
    private ActionType type;
    private List<AttackSubType> subtypes;
    private List<AttackCharacteristic> characteristics;

    public boolean hasCharacteristic(AttackCharacteristic characteristic) {
        if (characteristics == null) {
            return false;
        }

        return characteristics.contains(characteristic);
    }

    @Override
    public boolean isDoable() {
        return true;
    }
}
