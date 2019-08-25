package com.argentstew.simulator.battle.logger;

/**
 * com.argentstew.simulator.battle.logger
 * 8/25/2019
 *
 * @author Craig
 */
public interface BattleLogger {

    void log(String logMessage);
    void log(Object object);
    void debug(String logMessage);
}
