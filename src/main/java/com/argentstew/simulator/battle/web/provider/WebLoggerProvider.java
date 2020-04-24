package com.argentstew.simulator.battle.web.provider;

import com.argentstew.simulator.battle.logger.BattleLogger;
import com.argentstew.simulator.battle.web.log.WebLogger;
import com.argentstew.simulator.battle.web.service.DuelSimulatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * com.argentstew.simulator.battle.web.provider
 * 4/23/2020
 *
 * @author argen
 */
@Component
public class WebLoggerProvider implements LoggerProvider<WebLogger> {

    private static final Logger LOG = LogManager.getLogger(WebLoggerProvider.class);

    @Override
    public WebLogger getLogger(Writer writer) throws IOException {
        WebLogger logger = new WebLogger(writer);
        LOG.info("Writing log to {}.txt", logger.getUuid());
        return logger;
    }
}
