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
public class SeasonOneLeagueService implements LeagueService {

    private final SeasonOneTeamRepository teamRepository;
    private final SeasonOneDivisionRepository divisionRepository;
    private final SeasonOneFighterRepository fighterRepository;
    private final SeasonOneWeekRepository weekRepository;
    private final SeasonOneMatchRepository matchRepository;

    @Autowired
    public SeasonOneLeagueService(SeasonOneTeamRepository teamRepository,
                                  SeasonOneDivisionRepository divisionRepository,
                                  SeasonOneFighterRepository fighterRepository,
                                  SeasonOneWeekRepository weekRepository,
                                  SeasonOneMatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.divisionRepository = divisionRepository;
        this.fighterRepository = fighterRepository;
        this.weekRepository = weekRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public List<StandingsDTO> getStandings() {
        List<SeasonOneDivision> divisions = divisionRepository.findAll();
        Map<String, StandingsDTO> teamStandingsMap = new HashMap<>(divisions.size());
        for (SeasonOneDivision division : divisions) {
            StandingsDTO dto = new StandingsDTO();
            dto.setDivision(division.getName());
            dto.setTeam(division.getTeam().getName());
            teamStandingsMap.put(division.getTeam().getName(), dto);
        }

        List<SeasonOneMatch> matches = matchRepository.findAllByOrderByMatchDateAsc();
        for (SeasonOneMatch match : matches) {
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
        SeasonOneTeam team = getTeamByName(teamName);
        List<SeasonOneFighter> fighters = fighterRepository.findAllByTeam(team);
        return fighters.stream().map(SeasonOneFighter::getName).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getFullSchedule() {
        List<SeasonOneMatch> matches = matchRepository.findAllByOrderByMatchDateAsc();
        return matches.stream().map(this::mapMatchToDto).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getFullScheduleForTeam(String teamName) throws LeagueException {
        SeasonOneTeam team = getTeamByName(teamName);
        List<SeasonOneMatch> teamSchedule = matchRepository.findAllByTeamOrderByMatchDateAsc(team);
        return teamSchedule.stream().map(this::mapMatchToDto).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getWeeklySchedule(int week) {
        SeasonOneWeek seasonWeek = weekRepository.findByNumber(week);
        List<SeasonOneMatch> matches =
                matchRepository.findAllByMatchDateGreaterThanEqualAndMatchDateLessThanEqualOrderByMatchDateAsc(
                        seasonWeek.getStartDate(), seasonWeek.getEndDate()
                );
        return matches.stream().map(this::mapMatchToDto).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getWeeklyScheduleForTeam(int week, String teamName) throws LeagueException {
        SeasonOneTeam team = getTeamByName(teamName);
        SeasonOneWeek seasonWeek = weekRepository.findByNumber(week);
        List<SeasonOneMatch> matches =
                matchRepository.findAllByTeamAndMatchDateGreaterThanEqualAndMatchDateLessThanEqualOrderByMatchDateAsc(
                        team, seasonWeek.getStartDate(), seasonWeek.getEndDate()
                );
        return matches.stream().map(this::mapMatchToDto).collect(Collectors.toList());
    }

    private SeasonOneTeam getTeamByName(String teamName) throws LeagueException {
        SeasonOneTeam team = teamRepository.findByName(teamName);
        if (team == null) {
            throw new LeagueException("Team name not found!");
        }

        return team;
    }

    private ScheduleDTO mapMatchToDto(SeasonOneMatch match) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setDate(match.getMatchDate());
        dto.setHomeTeam(match.getHomeTeam().getName());
        dto.setAwayTeam(match.getAwayTeam().getName());
        dto.setWinner((match.getWinner() == null ? "" : match.getWinner().getName()));
        return dto;
    }
}
