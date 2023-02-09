package com.tek.java.coffee;

// Started 2/9/2023
// this class is a POJO - Plain Old Java Object
// this class can also be referred to as a bean or entity
public class MenuItem {

	// these private variables are called member variables
	// because they are defined at the class level
	// meaning they are available to the entire class not just the code block they
	// are defined in
	private String name = "";
	private double price = 0;
	
	// exercise: creating and adding quantity in stock as a variable
	// which takes us across the entire program between MenuItem.java and CoffeeShop.java
	private int quantityInStock = 0;


	// remember that these are called methods in java
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}


	// this is a constructor
	// the constructor does not have a return type
	// by default all objects have an empty argument constructor
	// that we do not have to code.
	public MenuItem() {

	}

	// this never gets done but he's showing us what happens?
	// this constructor takes in 2 parameters that will populate the member
	// variables
	// this constructor needs to be able to tell the difference
	// between the argument passed and the member variable of the class itself
	// by using this, it specifies the member variable of the class
	// this. refers to the instance of this class that is in memory
	public MenuItem(String name, double price, int quantityInStock) {
		// oh cool he's introducing us to this
		// this.name refers to the member variable, not the = name
		this.name = name;
		this.price = price;
		this.quantityInStock = quantityInStock;
	}


}
