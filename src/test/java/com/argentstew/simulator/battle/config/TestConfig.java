package com.argentstew.simulator.battle.config;

import com.argentstew.simulator.battle.web.repository.*;
import com.argentstew.simulator.battle.web.service.FighterService;
import com.argentstew.simulator.battle.web.service.SeasonOneLeagueService;
import com.argentstew.simulator.battle.web.service.SimulatorService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

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
    private SeasonOneLeagueService seasonOneLeagueService;

    @MockBean
    private HikariDataSource dataSource;

    @MockBean
    private SeasonOneTeamRepository teamRepository;

    @MockBean
    private SeasonOneDivisionRepository divisionRepository;

    @MockBean
    private SeasonOneFighterRepository fighterRepository;

    @MockBean
    private SeasonOneWeekRepository weekRepository;

    @MockBean
    private SeasonOneMatchRepository matchRepository;
}
