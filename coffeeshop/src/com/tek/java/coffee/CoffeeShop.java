package com.tek.java.coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// handle all operations in running a coffeeshop

public class CoffeeShop {

	public static final int PRINT_MENU = 1;
	public static final int ORDER_ITEM = 2;
	public static final int VIEW_CART = 3;
	public static final int EXIT = 4;

	// this is also a member variable that is private to this class
	// this variable IS accessible by everything in the class
	// look for decimalformat to see the opposite (example of scoping)
	private List<MenuItem> menuItems = new LinkedList<>();

	// this will create a cart for the customer's order
	private List<MenuItem> cart = new ArrayList<>();

	// explains that this is a form of encapsulation ^^^

	// all member variables are defined at the top of the file
	private Scanner scanner = new Scanner(System.in);

	public void initialize() {

		// Remember this comes from class MenuItem.java
		MenuItem item1 = new MenuItem();
		item1.setName("Small Coffee");
		item1.setPrice(4.30);
		item1.setQuantityInStock(70);

		menuItems.add(item1);

		MenuItem item2 = new MenuItem();
		item2.setName("Large Coffee");
		item2.setPrice(7.99);
		item2.setQuantityInStock(60);

		menuItems.add(item2);

		// this creates a new menu item using the constructor from MenuItem.java
		MenuItem item3 = new MenuItem("Small Cookie", 5.99, 12);
		menuItems.add(item3);

		// make your own constructor to see how it works
		MenuItem item4 = new MenuItem("Bagel Borgar", 4.99, 6);
		menuItems.add(item4);

		// we can compress the menuItem to 1 line of code
		// same as above but we are doing it in 1 line of code
		menuItems.add(new MenuItem("Egg Sandwich", 14.30, 7));

		// anonymous code block
		// it's all within the sort's parenthesis '()'
		// i should be getting clarification on it upon return
		// takes the argument and can make a new comparator
		// it's essentially a class within a method called

		// Comparator here is an interface
		menuItems.sort( // this is the sort function being called on the menuItems list itself
				new Comparator<MenuItem>() { // this is an anonymous block that creates a new comparator

					@Override // we can not instantiate an interface so we must provide the implementation for
								// that interface
					public int compare(MenuItem o1, MenuItem o2) { // right here in line
						Double p1 = o1.getPrice(); // these lines are implementing the sorting logic.
						Double p2 = o2.getPrice();

						return p1.compareTo(p2);
					} // this is the closing bracket for the compare method.

				} // this is the closing curly bracket for the comparator implementation
		); // this is the closing parenthesis for the .sort method

	}

	public void printMenuItems() {
		// we're building it out now
		System.out.println("Item Name\tPrice\tQuantity In Stock");
		System.out.println("---------\t-----\t-----------------");

		for (MenuItem item : menuItems) {
			// decimal format CANNOT be accessed by the whole class (example of scoping)
			// DecimalFormat df = new DecimalFormat("$###.00");
			// String formattedPrice = df.format(item.getPrice());
			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()) + "\t" + item.getQuantityInStock());

			// we can build on it later
			// just want something simple built now to build on it later
			// update: it got spruced up something fierce
			// decimal format mucks with me on the low but it is nice
		}

		System.out.println("---------\t-----\t-----------------");

	}

	public int menuPrompt() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to da hou\n");
		System.out.println(PRINT_MENU + ") Print Menu");
		System.out.println(ORDER_ITEM + ") Order Item");
		System.out.println(VIEW_CART + ") View Cart");
		System.out.println(EXIT + ") Exit Coffee Shop");
		System.out.println("\nPlease make a selection : ");

		int selection = scanner.nextInt();
		scanner.nextLine();

		System.out.println("");

		// hey we're finally doing a return in something
		return selection;

	}

	public void orderItem() {
		printMenuItems();
		System.out.print("Please enter the item name: ");
		String itemName = scanner.nextLine();

		// we changed menuItemExists to findMenuItemByItemName is an example of
		// refractoring
		MenuItem selectedItem = findMenuItemByItemName(itemName);
		if (selectedItem != null) {
			// you want to use selectedItem.getName() to ensure that any user error and
			// misalignments to the string sorted out
			System.out.println(selectedItem.getName() + " added to your cart.\n");
			cart.add(selectedItem);
		} else {
			System.out.println(itemName + " is not a valid selection.\n");
		}
	}

	// our first private function

	// this function combines 2 activites - checking if the itemName exists and
	// returning the menuItem if the itemName does exist.
	// in this function the arg itemName represents the user input
	// this is a very common pattern in software engineering - every day used
	// if the method returns null then the itemName was not found
	// if the method returns a MenuItem then the itemName was found.
	private MenuItem findMenuItemByItemName(String itemName) {
		// if the incoming itemName string is not instantiated (null)
		// then it can never be equal to a menu item.
		if (itemName == null) {
			return null;
		}

		// we want to trim any white space before or after the user input
		itemName = itemName.trim();

		for (MenuItem menuItem : menuItems) {
			String name = menuItem.getName();
			if (name.equalsIgnoreCase(itemName)) {
				return menuItem;
			}
		}
		return null;
	}

	public void viewCart() {
		System.out.println(cart.size() + " items in your cart:\n");

		double totalPrice = 0.0;

		System.out.println("Item Name\tPrice");
		System.out.println("---------\t-----");

		for (MenuItem item : cart) {
			// decimal format is a good example of scope inside a codeblock as you are using
			// it further down outside of the brackets
			System.out.println(item.getName() + "\t" + formatPrice(item.getPrice()));
			totalPrice = totalPrice + item.getPrice();
		}
		System.out.println("---------\t-----\n");

		System.out.println("Total Price\t " + formatPrice(totalPrice));
		System.out.println("");

	}

	private String formatPrice(double price) {
		DecimalFormat df = new DecimalFormat("$###.00");
		String formattedPrice = df.format(price);

		return formattedPrice;
	}
}
