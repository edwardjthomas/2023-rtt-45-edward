package com.java.day4;

public class Shape {

	// this means that only one variable x is created in memory for the entire JVM
	// this mostly gets used when you're creating a constant
	public static String SHAPE_NAME = "Shape";

	// does not include the static keyword
	public String NOT_STATIC = "Not static";

	public void printShape() {
		System.out.println("I am a shape");
	}

	// i finally couldn't keep up
	public void createShape() {
		System.out.println("This is a shape");
	}
}
