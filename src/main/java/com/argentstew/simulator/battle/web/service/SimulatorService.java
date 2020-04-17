package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.model.SimulationResult;

import java.io.IOException;
import java.util.List;

/**
 * com.argentstew.simulator.battle.web.service
 * 4/16/2020
 *
 * @author argen
 */
public interface SimulatorService {

    SimulationResult run(String fighter1Name, String fighter2Name) throws IOException;

    String fetchSimulation(String id) throws IOException;

    List<String> getFighters();
}
