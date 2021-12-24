package com.argentstew.simulator.battle.web.aws.exception;

/**
 * com.argentstew.simulator.battle.exception
 * 12/20/2021
 *
 * @author argen
 */
public class S3FileException extends RuntimeException {

    public S3FileException(String message) {
        super(message);
    }

    public S3FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public S3FileException(Throwable cause) {
        super(cause);
    }
}
