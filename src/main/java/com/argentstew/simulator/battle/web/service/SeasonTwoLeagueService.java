package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.exception.LeagueException;
import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;
import com.argentstew.simulator.battle.web.persistence.*;
import com.argentstew.simulator.battle.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * com.argentstew.simulator.battle.web.service
 * 5/2/2020
 *
 * @author argen
 */
@Service
public class SeasonTwoLeagueService implements LeagueService {

    private final SeasonTwoTeamRepository teamRepository;
    private final SeasonTwoDivisionRepository divisionRepository;
    private final SeasonTwoFighterRepository fighterRepository;
    private final SeasonTwoWeekRepository weekRepository;
    private final SeasonTwoMatchRepository matchRepository;

    @Autowired
    public SeasonTwoLeagueService(SeasonTwoTeamRepository teamRepository,
                                  SeasonTwoDivisionRepository divisionRepository,
                                  SeasonTwoFighterRepository fighterRepository,
                                  SeasonTwoWeekRepository weekRepository,
                                  SeasonTwoMatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.divisionRepository = divisionRepository;
        this.fighterRepository = fighterRepository;
        this.weekRepository = weekRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public List<String> getTeams() {
        List<SeasonTwoTeam> teams = teamRepository.findAll();
        return teams.stream().filter((team) -> !team.getName().equals("Draw")).map(SeasonTwoTeam::getName)
                .sorted().collect(Collectors.toList());
    }

    @Override
    public List<StandingsDTO> getStandings() {
        List<SeasonTwoDivision> divisions = divisionRepository.findAll();
        Map<String, StandingsDTO> teamStandingsMap = new HashMap<>(divisions.size());
        for (SeasonTwoDivision division : divisions) {
            StandingsDTO dto = new StandingsDTO();
            dto.setDivision(division.getName());
            dto.setTeam(division.getTeam().getName());
            teamStandingsMap.put(division.getTeam().getName(), dto);
        }

        List<SeasonTwoMatch> matches = matchRepository.findAllByOrderByMatchDateAsc();
        for (SeasonTwoMatch match : matches) {
            String winner = match.getWinner().getName();
            if ("draw".equalsIgnoreCase(winner)) {
                StandingsDTO homeTeamDto = teamStandingsMap.get(match.getHomeTeam().getName());
                homeTeamDto.setDraws(homeTeamDto.getDraws() + 1);
                StandingsDTO awayTeamDto = teamStandingsMap.get(match.getAwayTeam().getName());
                awayTeamDto.setDraws(awayTeamDto.getDraws() + 1);
            } else if (match.getHomeTeam().getName().equals(winner)) {
                StandingsDTO homeTeamDto = teamStandingsMap.get(match.getHomeTeam().getName());
                homeTeamDto.setWins(homeTeamDto.getWins() + 1);
                StandingsDTO awayTeamDto = teamStandingsMap.get(match.getAwayTeam().getName());
                awayTeamDto.setLosses(awayTeamDto.getLosses() + 1);
            } else if (match.getAwayTeam().getName().equals(winner)) {
                StandingsDTO homeTeamDto = teamStandingsMap.get(match.getHomeTeam().getName());
                homeTeamDto.setLosses(homeTeamDto.getLosses() + 1);
                StandingsDTO awayTeamDto = teamStandingsMap.get(match.getAwayTeam().getName());
                awayTeamDto.setWins(awayTeamDto.getWins() + 1);
            }
        }

        return new ArrayList<>(teamStandingsMap.values());
    }

    @Override
    public List<String> getRosterByTeam(String teamName) throws LeagueException {
        SeasonTwoTeam team = getTeamByName(teamName);
        List<SeasonTwoFighter> fighters = fighterRepository.findAllByTeamOrderByName(team);
        return fighters.stream().map(SeasonTwoFighter::getName).collect(Collectors.toList());
    }

    @Override
    public List<Integer> getWeeks() {
        List<SeasonTwoWeek> weeks = weekRepository.findAll();
        return weeks.stream().map(SeasonTwoWeek::getNumber).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getFullSchedule() {
        List<SeasonTwoMatch> matches = matchRepository.findAllByOrderByMatchDateAsc();
        return matches.stream().map(this::mapMatchToDto).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getFullScheduleForTeam(String teamName) throws LeagueException {
        SeasonTwoTeam team = getTeamByName(teamName);
        List<SeasonTwoMatch> teamSchedule = matchRepository.findAllByTeamOrderByMatchDateAsc(team);
        return teamSchedule.stream().map(this::mapMatchToDto).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getWeeklySchedule(int week) {
        SeasonTwoWeek seasonWeek = weekRepository.findByNumberOrderByNumber(week);
        List<SeasonTwoMatch> matches =
                matchRepository.findAllByMatchDateGreaterThanEqualAndMatchDateLessThanEqualOrderByMatchDateAsc(
                        seasonWeek.getStartDate(), seasonWeek.getEndDate()
                );
        return matches.stream().map(this::mapMatchToDto).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getWeeklyScheduleForTeam(int week, String teamName) throws LeagueException {
        SeasonTwoTeam team = getTeamByName(teamName);
        SeasonTwoWeek seasonWeek = weekRepository.findByNumberOrderByNumber(week);
        List<SeasonTwoMatch> matches =
                matchRepository.findAllByTeamAndMatchDateGreaterThanEqualAndMatchDateLessThanEqualOrderByMatchDateAsc(
                        team, seasonWeek.getStartDate(), seasonWeek.getEndDate()
                );
        return matches.stream().map(this::mapMatchToDto).collect(Collectors.toList());
    }

    private SeasonTwoTeam getTeamByName(String teamName) throws LeagueException {
        SeasonTwoTeam team = teamRepository.findByName(teamName);
        if (team == null) {
            throw new LeagueException("Team name not found!");
        }

        return team;
    }

    private ScheduleDTO mapMatchToDto(SeasonTwoMatch match) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setDate(match.getMatchDate());
        dto.setHomeTeam(match.getHomeTeam().getName());
        dto.setAwayTeam(match.getAwayTeam().getName());
        dto.setWinner((match.getWinner() == null ? "" : match.getWinner().getName()));
        return dto;
    }
}
