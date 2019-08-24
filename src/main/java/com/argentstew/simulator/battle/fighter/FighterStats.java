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
public class FighterStats {

    // factors into damage done by melee attacks
    private int strength;

    // factors into damage done by ranged attacks and hit chance with physical attacks
    private int dexterity;

    // factors into hit chance with ranged attacks
    private int aim;

    // factors into critical hit chance with physical and ranged attacks and dodge chance
    private int agility;

    // factors into attack timing and dodge chance
    private int speed;

    // factors into damage done by magical attacks and strategy
    private int intellect;

    // factors into critical hit chance with magic attacks
    private int willpower;

    // factors into miss chance
    private int size;

    // factors into enemy grapple attack success
    private int weight;
}
