package com.java.feb16;

// how to build your own custom exception
// we have to create this on the SBA

public class NegativePositionException extends Exception {

	public NegativePositionException(String message) {
		super(message);
	}
}
