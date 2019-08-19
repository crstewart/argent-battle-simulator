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

    // factors into damage reduction from physical attacks
    private int defense;

    // factors into damage done by ranged attacks and dodge chance
    private int agility;

    // factors into attack timing and dodge chance
    private int speed;

    // factors into damage done by magical attacks and strategy
    private int intellect;

    // factors into damage reduction from magical attacks
    private int magicDefense;

    // factors into dodge chance
    private int size;

    // factors into enemy grapple attack success
    private int weight;
}
