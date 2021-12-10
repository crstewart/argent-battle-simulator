package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;
import com.argentstew.simulator.battle.web.persistence.*;
import com.argentstew.simulator.battle.web.repository.MatchRepository;
import com.argentstew.simulator.battle.web.repository.TeamRepository;
import com.argentstew.simulator.battle.web.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * com.argentstew.simulator.battle.web.service
 * 12/10/2021
 *
 * @author argen
 */
@Service
public class BasicLeagueService implements LeagueService {

    private final TeamRepository teamRepository;
    private final WeekRepository weekRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public BasicLeagueService(TeamRepository teamRepository,
                              WeekRepository weekRepository,
                              MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.weekRepository = weekRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public List<String> getTeamsBySeason(String seasonId) {
        return teamRepository.findAllByDivisionSeasonId(UUID.fromString(seasonId)).stream().map(Team::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getTeamsByDivision(String divisionId) {
        return teamRepository.findAllByDivisionId(UUID.fromString(divisionId)).stream().map(Team::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<StandingsDTO> getStandings(String seasonId) {
        UUID uuid = UUID.fromString(seasonId);
        Map<String, StandingsDTO> standings = teamRepository.findAllByDivisionSeasonId(uuid)
                .stream().collect(Collectors.toMap(Team::getName, team -> StandingsDTO.builder()
                        .team(team.getName()).division(team.getDivision().getName()).build()));

        List<Match> matches = matchRepository.findAllBySeasonIdOrderByStartDateAsc(uuid);
        for (Match match : matches) {
            if (match.getWinner() == MatchStatus.HOME_TEAM_WINS) {
                int wins = standings.get(match.getHomeTeam().getName()).getWins();
                int losses = standings.get(match.getAwayTeam().getName()).getLosses();
                standings.get(match.getHomeTeam().getName()).setWins(wins + 1);
                standings.get(match.getAwayTeam().getName()).setLosses(losses + 1);
            } else if (match.getWinner() == MatchStatus.AWAY_TEAM_WINS) {
                int wins = standings.get(match.getAwayTeam().getName()).getWins();
                int losses = standings.get(match.getHomeTeam().getName()).getLosses();
                standings.get(match.getAwayTeam().getName()).setWins(wins + 1);
                standings.get(match.getHomeTeam().getName()).setLosses(losses + 1);
            } else if (match.getWinner() == MatchStatus.DRAW) {
                int homeDraws = standings.get(match.getHomeTeam().getName()).getDraws();
                int awayDraws = standings.get(match.getAwayTeam().getName()).getDraws();
                standings.get(match.getHomeTeam().getName()).setDraws(homeDraws + 1);
                standings.get(match.getAwayTeam().getName()).setDraws(awayDraws + 1);
            }
        }

        return new ArrayList<>(standings.values());
    }

    @Override
    public List<String> getRosterByTeam(String teamId) {
        return teamRepository.findById(UUID.fromString(teamId))
                .orElse(Team.builder().fighters(Collections.emptyList()).build()).getFighters().stream()
                .map(TeamFighter::getFighter).map(Fighter::getName).sorted().collect(Collectors.toList());
    }

    @Override
    public List<Integer> getWeeks(String seasonId) {
        return weekRepository.getNumberBySeasonIdOrderByNumberAsc(UUID.fromString(seasonId));
    }

    @Override
    public List<ScheduleDTO> getFullScheduleForSeason(String seasonId) {
        return matchRepository.findAllBySeasonIdOrderByStartDateAsc(UUID.fromString(seasonId)).stream()
                .map(ScheduleDTO::from).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getFullScheduleForTeam(String teamId) {
        UUID uuid = UUID.fromString(teamId);
        return matchRepository.findAllByHomeTeamIdOrAwayTeamIdOrderByStartDateAsc(uuid, uuid)
                .stream().map(ScheduleDTO::from).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getWeeklyScheduleForSeason(String seasonId, int weekNumber) {
        Week week = weekRepository.findBySeasonIdAndNumber(UUID.fromString(seasonId), weekNumber);
        return matchRepository
                .findAllBySeasonIdAndStartDateGreaterThanEqualAndStartDateLessThanEqualOrderByStartDateAsc(
                        UUID.fromString(seasonId), week.getStartDate(), week.getEndDate()
                ).stream().map(ScheduleDTO::from).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getWeeklyScheduleForTeam(String teamId, int weekNumber) {
        UUID uuid = UUID.fromString(teamId);
        Week week = weekRepository.findBySeasonIdAndNumber(UUID.fromString(teamId), weekNumber);
        return matchRepository
                .findAllByHomeTeamIdOrAwayTeamIdAndStartDateGreaterThanEqualAndStartDateLessThanEqualOrderByStartDateAsc(
                        uuid, uuid, week.getStartDate(), week.getEndDate()
                ).stream().map(ScheduleDTO::from).collect(Collectors.toList());
    }
}
