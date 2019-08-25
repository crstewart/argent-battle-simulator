package com.argentstew.simulator.battle.logger;

/**
 * com.argentstew.simulator.battle.logger
 * 8/25/2019
 *
 * @author Craig
 */
public class StandardBattleLogger implements BattleLogger {

    @Override
    public void log(String logMessage) {
        System.out.println(logMessage);
    }

    @Override
    public void log(Object object) {
        System.out.println(object);
    }

    @Override
    public void debug(String logMessage) {
        // no-op
    }
}
