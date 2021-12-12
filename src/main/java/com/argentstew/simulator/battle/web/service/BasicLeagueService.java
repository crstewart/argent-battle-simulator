package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.model.ScheduleDTO;
import com.argentstew.simulator.battle.web.model.StandingsDTO;
import com.argentstew.simulator.battle.web.persistence.Match;
import com.argentstew.simulator.battle.web.persistence.MatchStatus;
import com.argentstew.simulator.battle.web.persistence.Team;
import com.argentstew.simulator.battle.web.persistence.Week;
import com.argentstew.simulator.battle.web.repository.MatchRepository;
import com.argentstew.simulator.battle.web.repository.TeamRepository;
import com.argentstew.simulator.battle.web.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
    public List<Integer> getWeeks(String seasonId) {
        return weekRepository.findAllBySeasonIdOrderByNumberAsc(UUID.fromString(seasonId)).stream()
                .map(Week::getNumber).sorted().collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getFullScheduleForSeason(String seasonId) {
        return matchRepository.findAllBySeasonIdOrderByStartDateAsc(UUID.fromString(seasonId)).stream()
                .map(ScheduleDTO::from).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getFullScheduleForTeam(Team team) {
        return matchRepository.findAllByHomeTeamOrAwayTeamOrderByStartDateAsc(team, team)
                .stream().map(ScheduleDTO::from).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getWeeklyScheduleForSeason(String seasonId, int weekNumber) {
        Week week = weekRepository.findBySeasonIdAndNumber(UUID.fromString(seasonId), weekNumber);
        return matchRepository
                .findAllByStartDateBetweenAndSeasonIdOrderByStartDateAsc(
                        week.getStartDate(), week.getEndDate(), UUID.fromString(seasonId)
                ).stream().map(ScheduleDTO::from).collect(Collectors.toList());
    }

    @Override
    public List<ScheduleDTO> getWeeklyScheduleForTeam(Team team, int weekNumber) {
        Week week = weekRepository.findBySeasonIdAndNumber(team.getDivision().getSeason().getId(), weekNumber);
        return matchRepository
                .findAllByStartDateBetweenAndHomeTeamOrStartDateBetweenAndAwayTeamOrderByStartDateAsc(
                        week.getStartDate(), week.getEndDate(), team, week.getStartDate(), week.getEndDate(), team
                ).stream().map(ScheduleDTO::from).collect(Collectors.toList());
    }
}
