package com.argentstew.simulator.battle.config;

import com.argentstew.simulator.battle.web.repository.FighterRepository;
import com.argentstew.simulator.battle.web.repository.MatchRepository;
import com.argentstew.simulator.battle.web.repository.TeamRepository;
import com.argentstew.simulator.battle.web.repository.WeekRepository;
import com.argentstew.simulator.battle.web.service.FighterService;
import com.argentstew.simulator.battle.web.service.LeagueService;
import com.argentstew.simulator.battle.web.service.SimulatorService;
import com.argentstew.simulator.battle.web.service.TeamService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * com.argentstew.simulator.battle.config
 * 5/3/2020
 *
 * @author argen
 */
@TestConfiguration
public class TestConfig {

    @MockBean
    private SimulatorService simulatorService;

    @MockBean
    private FighterService fighterService;

    @MockBean
    private LeagueService leagueService;

    @MockBean
    private TeamService teamService;

    @MockBean
    private HikariDataSource dataSource;

    @MockBean
    private FighterRepository fighterRepository;

    @MockBean
    private MatchRepository matchRepository;

    @MockBean
    private TeamRepository teamRepository;

    @MockBean
    private WeekRepository weekRepository;
}
