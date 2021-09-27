package com.argentstew.simulator.battle.trait.impl;

import com.argentstew.simulator.battle.action.AttackAction;
import com.argentstew.simulator.battle.action.attack.AttackSubType;
import com.argentstew.simulator.battle.reporting.DamageReport;
import com.argentstew.simulator.battle.trait.AbstractArmorTrait;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * com.argentstew.simulator.battle.trait.impl
 * 3/27/2020
 *
 * @author argen
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class Survivalist extends AbstractArmorTrait {

    private static final List<AttackSubType> RESISTED_ATTACKS = Collections.unmodifiableList(Arrays.asList(
            AttackSubType.PUNCH, AttackSubType.KICK, AttackSubType.HEADBUTT, AttackSubType.SLAM, AttackSubType.SLASH,
            AttackSubType.PIERCE, AttackSubType.HACK, AttackSubType.HANDGUN, AttackSubType.SHOTGUN, AttackSubType.RIFLE,
            AttackSubType.GRAPPLE
    ));

    private final String name = "Survivalist";

    @Override
    protected int recalculateDamage(DamageReport report) {
        AttackAction attack = report.getAttack();
        if (attack.getSubtypes().stream().anyMatch(RESISTED_ATTACKS::contains)) {
            double damageMultiplier = 1 - (Math.random() * 0.1);
            report.setDamage((int) Math.round(report.getDamage() * damageMultiplier));
        }

        return report.getDamage();
    }
}
