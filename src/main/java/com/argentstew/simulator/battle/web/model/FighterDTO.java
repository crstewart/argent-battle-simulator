package com.argentstew.simulator.battle.web.model;

import lombok.Data;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.model
 * 4/19/2020
 *
 * @author argen
 */
@Data
public class FighterDTO {

    private String name;
    private String description;
    private List<String> classifications;

    // stats
    private int hp;
    private int sp;
    private int maxSp;
    private double strength;
    private double toughness;
    private double dexterity;
    private double aim;
    private double agility;
    private double speed;
    private double intellect;
    private double willpower;
    private double size;
    private double weight;

    // characteristics
    private List<String> traits;
    private List<String> defenses;
    private String strategy;

    // moveset
    private List<AttackDTO> attacks;
    private AttackDTO xStrike;
    private List<GuardDTO> guards;
    private List<GuardDTO> heals;
}
