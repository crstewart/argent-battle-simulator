package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.persistence.Team;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.service
 * 12/10/2021
 *
 * @author argen
 */
public interface TeamService {

    Team getTeam(String seasonId, String teamName);

    List<String> getRosterByTeam(String seasonId, String teamName);
}
