package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.Battle;
import com.argentstew.simulator.battle.factory.FighterFactory;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.web.log.LogFetcher;
import com.argentstew.simulator.battle.web.log.WebLogger;
import com.argentstew.simulator.battle.web.model.SimulationResult;
import com.argentstew.simulator.battle.web.provider.BattleProvider;
import com.argentstew.simulator.battle.web.provider.LoggerProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;

/**
 * com.argentstew.simulator.battle.web.service
 * 4/16/2020
 *
 * @author argen
 */
@Service
public class DuelSimulatorService implements SimulatorService {

    private static final Logger LOG = LogManager.getLogger(DuelSimulatorService.class);

    private final FighterFactory fighterFactory;
    private final BattleProvider battleProvider;
    private final LoggerProvider<WebLogger> loggerProvider;
    private final LogFetcher logFetcher;

    @Autowired
    public DuelSimulatorService(FighterFactory fighterFactory, BattleProvider battleProvider,
                                LoggerProvider<WebLogger> loggerProvider, LogFetcher logFetcher) {
        this.fighterFactory = fighterFactory;
        this.battleProvider = battleProvider;
        this.loggerProvider = loggerProvider;
        this.logFetcher = logFetcher;
    }

    @Override
    public SimulationResult run(String fighter1Name, String fighter2Name) throws IOException {
        Fighter fighter1 = fighterFactory.getFighter(fighter1Name);
        Fighter fighter2 = fighterFactory.getFighter(fighter2Name);
        LOG.info("Running simulation between {} and {}", fighter1.getName(), fighter2.getName());

        StringWriter stringWriter = new StringWriter();
        WebLogger logger = loggerProvider.getLogger(stringWriter);
        Fighter winner;
        try {
            logger.open();

            Battle battle = battleProvider.setUpBattle(fighter1, fighter2, logger);
            battle.announce();
            battle.start();

            winner = battle.determineWinner();
        } finally {
            logger.close();
        }

        SimulationResult result = new SimulationResult();
        result.setWinner(winner == null ? "Draw" : winner.getName());
        result.setMessage(stringWriter.toString());
        result.setId(logger.getUuid());

        return result;
    }

    @Override
    public String fetchSimulation(String id) throws IOException {
        return logFetcher.getFile(id);
    }
}
