package com.argentstew.simulator.battle.web.exception;

/**
 * com.argentstew.simulator.battle.exception
 * 1/2/2022
 *
 * @author argen
 */
public class MissingBlogException extends RuntimeException {

    public MissingBlogException(String message) {
        super(message);
    }

    public MissingBlogException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingBlogException(Throwable cause) {
        super(cause);
    }
}
