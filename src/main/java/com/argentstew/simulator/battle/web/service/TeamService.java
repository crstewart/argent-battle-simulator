package com.argentstew.simulator.battle.web.service;

import java.util.UUID;

/**
 * com.argentstew.simulator.battle.web.service
 * 12/10/2021
 *
 * @author argen
 */
public interface TeamService {

    UUID getTeamId(String seasonId, String teamName);
}
