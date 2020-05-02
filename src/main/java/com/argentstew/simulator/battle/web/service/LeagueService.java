package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.exception.LeagueException;
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

    List<String> getTeams();

    List<StandingsDTO> getStandings();

    List<String> getRosterByTeam(String teamName) throws LeagueException;

    List<Integer> getWeeks();

    List<ScheduleDTO> getFullSchedule();

    List<ScheduleDTO> getFullScheduleForTeam(String teamName) throws LeagueException;

    List<ScheduleDTO> getWeeklySchedule(int week) throws LeagueException;

    List<ScheduleDTO> getWeeklyScheduleForTeam(int week, String teamName) throws LeagueException;
}
