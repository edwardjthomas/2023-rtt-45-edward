package com.java.day6.implement;

// abstract means that this shape class can not be instantiated
// it must have a child class that extends shape which can then be instantiated
// having the implements AreaCalculation interface here also forces all subclasses to implement the interface methods
public abstract class Shape implements AreaCalculation {

	// this method can be overwritten by a child class but it isn't required
	// there are more words in eric's files. i just can't keep up
	private String name;

	public String getShapeName() {
		return name;
	}

	public void setShapeName(String name) {
		this.name = name;
	}

	// depreciated
//	public String shapeName() {
//		return "Shape";
//	}

	// this is overriding the toString of Object which is the parent of all classes
	// so square and triangle currently overrides this method
	@Override
	public String toString() {
		return "The area of " + getShapeName() + " is " + calculateArea();
	}
	// circle doesn't have a toString in its file but it still appears if ran
}
