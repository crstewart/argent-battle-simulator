package com.argentstew.simulator.battle.web.service;

import com.argentstew.simulator.battle.Battle;
import com.argentstew.simulator.battle.DuelBattle;
import com.argentstew.simulator.battle.arena.DuelArena;
import com.argentstew.simulator.battle.fighter.Fighter;
import com.argentstew.simulator.battle.vg.factory.VgFighterFactory;
import com.argentstew.simulator.battle.web.log.LogFetcher;
import com.argentstew.simulator.battle.web.log.WebLogger;
import com.argentstew.simulator.battle.web.model.SimulationResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * com.argentstew.simulator.battle.web.service
 * 4/16/2020
 *
 * @author argen
 */
@Service
public class DuelSimulatorService implements SimulatorService {

    private static final Logger LOG = LogManager.getLogger(DuelSimulatorService.class);

    private final VgFighterFactory fighterFactory;

    @Autowired
    public DuelSimulatorService(VgFighterFactory fighterFactory) {
        this.fighterFactory = fighterFactory;
    }

    @Override
    public SimulationResult run(String fighter1Name, String fighter2Name) throws IOException {
        Fighter fighter1 = fighterFactory.getFighter(fighter1Name);
        Fighter fighter2 = fighterFactory.getFighter(fighter2Name);

        StringWriter stringWriter = new StringWriter();
        WebLogger logger = new WebLogger(stringWriter);
        LOG.info("Writing log to {}.txt", logger.getUuid());
        Fighter winner;
        try {
            logger.open();

            DuelArena arena = new DuelArena();
            arena.setLeftFighter(fighter1);
            arena.setRightFighter(fighter2);

            Battle battle = new DuelBattle(fighter1, fighter2, logger);
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
        LogFetcher logFetcher = new LogFetcher(id);
        return logFetcher.getFile();
    }
}
