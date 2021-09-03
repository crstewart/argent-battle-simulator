package com.argentstew.simulator.battle.exception;

/**
 * com.argentstew.simulator.battle.exception
 * 9/3/2021
 *
 * @author argen
 */
public class TraitNotFoundException extends RuntimeException {

    public TraitNotFoundException(String message) {
        super(message);
    }

    public TraitNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TraitNotFoundException(Throwable cause) {
        super(cause);
    }
}
