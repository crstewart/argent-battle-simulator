package com.argentstew.simulator.battle.web.provider;

import com.argentstew.simulator.battle.logger.BattleLogger;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * com.argentstew.simulator.battle.web.provider
 * 4/23/2020
 *
 * @author argen
 */
public interface LoggerProvider<T extends BattleLogger> {

    T getLogger(Writer writer) throws IOException;
}
