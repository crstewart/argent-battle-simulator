package com.argentstew.simulator.battle.fighter;

import lombok.Builder;
import lombok.Data;

/**
 * com.argentstew.simulator.battle.fighter
 * 8/18/2019
 *
 * @author Craig
 */
@Data
@Builder
public class FighterVariance {

    private double damageVariance;
    private double critChance;
}
