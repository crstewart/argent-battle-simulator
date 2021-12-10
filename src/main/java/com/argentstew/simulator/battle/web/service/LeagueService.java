package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;

import java.util.List;

/**
 * com.argentstew.simulator.battle.web.service
 * 5/2/2020
 *
 * @author argen
 */
public interface LeagueService {

    List<String> getTeamsBySeason(String seasonId);

    List<String> getTeamsByDivision(String divisionId);

    List<StandingsDTO> getStandings(String seasonId);

    List<String> getRosterByTeam(String teamId);

    List<Integer> getWeeks(String seasonId);

    List<ScheduleDTO> getFullScheduleForSeason(String seasonId);

    List<ScheduleDTO> getFullScheduleForTeam(String teamName);

    List<ScheduleDTO> getWeeklyScheduleForSeason(String seasonId, int weekNumber);

    List<ScheduleDTO> getWeeklyScheduleForTeam(String teamId, int weekNumber);
}
