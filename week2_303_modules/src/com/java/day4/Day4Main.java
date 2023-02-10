package com.java.day4;

public class Day4Main {

	public static void main(String[] args) {

		// example of inheritance
		Shape s = new Shape();
		s.printShape();
		System.out.println("Accessing shape name staticly from shape " + Shape.SHAPE_NAME);

		// however because our NOT_STATIC member variable is not static we must use an
		// instance of the class
		// for example
		// Shape.NOT_STATIC; // this cannot be done
		System.out.println(s.NOT_STATIC); // this works because s has been created as a new object in memory

		// this is calling the static method on the shape object.
		// not that we do not need to use an instance .. this is similar to the arrays
		// class
		s.createShape();

		System.out.println("================");

		Square sq = new Square();
		sq.printShape(); // inherited from Shape
		sq.printSquare(); // native to square

		System.out.println("================");

		Circle c = new Circle();
		c.printShape(); // inherited from Shape
		c.printCircle(); // native to Circle
	}

}
