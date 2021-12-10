package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.web.exception.LeagueException;
import com.argentstew.simulator.battle.web.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    public UUID getTeamId(String seasonId, String teamName) {
        return teamRepository.getByDivisionSeasonIdAndName(UUID.fromString(seasonId), teamName)
                .orElseThrow(() -> new LeagueException("Team does not exist!")).getId();
    }
}
