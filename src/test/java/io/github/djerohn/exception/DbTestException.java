package io.github.djerohn.exception;

public class DbTestException extends RuntimeException {
	public DbTestException(String message, Throwable cause) {
		super(message, cause);
	}

	public DbTestException(String message) {
		super(message);
	}

	public DbTestException(Throwable cause) {
		super(cause);
	}
}
