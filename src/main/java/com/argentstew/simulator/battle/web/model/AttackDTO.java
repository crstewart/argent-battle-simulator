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
public class AttackDTO {

    private String name;
    private String description;
    private String attackType;
    private int power;
    private double variance;
    private double speed;
    private List<String> attackSubTypes;
    private List<String> characteristics;
}
