package com.java.day4;

public class Square extends Shape {
	// this means that only one variable x is created in memory for the entire JVM
	// this mostly gets used when you're creating a constant
	public static String x = "100";
	
	@Override // using the annotation helps readers know HEY THIS TAKES OVER A METHOD-
	public void printShape() {
		// super means "run it in the parent class
		// so in this case we are getting all of the functionality in the parent plus
		// the additional functionality in the child square
		super.printShape();
		System.out.println("This is a different implementation of print shape in the square");
	}

	public void printSquare() {
		System.out.println("I am a square and my parent's name is " + SHAPE_NAME);
	}

}
