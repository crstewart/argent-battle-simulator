package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.exception.LeagueException;
import com.argentstew.simulator.battle.web.persistence.Fighter;
import com.argentstew.simulator.battle.web.persistence.Team;
import com.argentstew.simulator.battle.web.persistence.TeamFighter;
import com.argentstew.simulator.battle.web.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * com.argentstew.simulator.battle.web.service
 * 12/10/2021
 *
 * @author argen
 */
@Service
public class TempTeamService implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TempTeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team getTeam(String seasonId, String teamName) {
        return teamRepository.getByDivisionSeasonIdAndName(UUID.fromString(seasonId), teamName)
                .orElseThrow(() -> new LeagueException("Team does not exist!"));
    }

    @Override
    public List<String> getRosterByTeam(String seasonId, String teamName) {
        return getTeam(seasonId, teamName).getFighters().stream().map(TeamFighter::getFighter).map(Fighter::getName)
                .collect(Collectors.toList());
    }
}
