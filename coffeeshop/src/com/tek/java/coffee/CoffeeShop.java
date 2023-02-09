package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

// handle all operations in running a coffeeshop

public class CoffeeShop {

	// this is also a member variable that is private to this class
	//this variable IS accessible by everything in the class
	// look for decimalformat to see the opposite (example of scoping)
	private List<MenuItem> menuItems = new ArrayList<>();

	// explains that this is a form of encapsulation ^^^

	public void initialize() {

		// Remember this comes from class MenuItem.java
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);

		menuItems.add(item1);

		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(5.99);

		menuItems.add(item2);

		// this creates a new menu item using the constructor from MenuItem.java
		MenuItem item3 = new MenuItem("Small Cookie", 9.99, 12);
		menuItems.add(item3);

		// make your own constructor to see how it works
		MenuItem item4 = new MenuItem("Bagel", 4.99, 6);
		menuItems.add(item4);

		// we can compress the menuItem to 1 line of code
		// same as above but we are doing it in 1 line of code
		menuItems.add(new MenuItem("Egg Sandwich", 14.30, 7));

	}

	public void printMenuItems() {
		// we're building it out now
		System.out.println("Item Name\tPrice\tQuantity In Stock");
		System.out.println("---------\t-----\t-----------------");
		for (MenuItem item : menuItems) {
			// decimal format CANNOT be accessed by the whole class (example of scoping)
			DecimalFormat df = new DecimalFormat("$###.00");
			String formattedPrice = df.format(item.getPrice());
			System.out.println(item.getName() + "\t" + formattedPrice + "\t" + item.getQuantityInStock());

			// we can build on it later
			// just want something simple built now to build on it later
			// update: it got spruced up something fierce
			// decimal format mucks with me on the low but it is nice
		}
	}

}
