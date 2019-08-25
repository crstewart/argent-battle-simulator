package com.argentstew.simulator.battle.logger;

/**
 * com.argentstew.simulator.battle.logger
 * 8/25/2019
 *
 * @author Craig
 */
public class NoopBattleLogger implements BattleLogger {

    @Override
    public void log(String logMessage) {
        // no-op
    }

    @Override
    public void log(Object object) {
        // no-op
    }

    @Override
    public void debug(String logMessage) {
        // no-op
    }
}
