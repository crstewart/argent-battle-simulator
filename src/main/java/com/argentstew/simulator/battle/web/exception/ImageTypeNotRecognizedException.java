package com.argentstew.simulator.battle.web.exception;

/**
 * com.argentstew.simulator.battle.exception
 * 12/20/2021
 *
 * @author argen
 */
public class ImageTypeNotRecognizedException extends RuntimeException {

    public ImageTypeNotRecognizedException(String message) {
        super(message);
    }

    public ImageTypeNotRecognizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImageTypeNotRecognizedException(Throwable cause) {
        super(cause);
    }
}
