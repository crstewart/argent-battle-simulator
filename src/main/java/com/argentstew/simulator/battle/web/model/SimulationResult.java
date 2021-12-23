package com.argentstew.simulator.battle.web.model;

import lombok.Data;

/**
 * com.argentstew.simulator.battle.web.model
 * 4/16/2020
 *
 * @author argen
 */
@Data
public class SimulationResult {

    private FighterDTO fighter1;
    private FighterDTO fighter2;
    private String winner;
    private String message;
    private String id;
}
