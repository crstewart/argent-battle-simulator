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

    // factors into damage done and stun chance with melee attacks
    private double strength;

    // factors into stun defense for physical and ranged attacks
    private double toughness;

    // factors into damage done by ranged attacks and hit chance with melee attacks
    private double dexterity;

    // factors into hit chance and critical hit chance with ranged attacks
    private double aim;

    // factors into critical hit chance with physical and ranged attacks and dodge chance
    private double agility;

    // factors into attack timing and dodge chance
    private double speed;

    // factors into damage done by magical attacks and strategy
    private double intellect;

    // factors into critical hit chance and stun defense with magic attacks
    private double willpower;

    // factors into miss chance
    private double size;

    // factors into enemy grapple attack success
    private double weight;
}
