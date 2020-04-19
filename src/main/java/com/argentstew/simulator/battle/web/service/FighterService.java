package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.model.FighterDTO;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.service
 * 4/19/2020
 *
 * @author argen
 */
public interface FighterService {

    List<String> getFighters();

    FighterDTO getFighter(String name);
}
