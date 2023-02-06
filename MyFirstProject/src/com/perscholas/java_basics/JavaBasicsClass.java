package com.perscholas.java_basics;

/*
 * 1 Write a program that declares 2 integer variables, assigns an integer to each, and adds them together. Assign the sum to a variable. Print out the result.
 
2 Write a program that declares 2 double variables, assigns a number to each, and adds them together. Assign the sum to a variable. Print out the result.
 
3 Write a program that declares an integer variable and a double variable, assigns numbers to each, and adds them together. Assign the sum to a variable. Print out the result. What variable type must the sum be?
 
4 Write a program that declares 2 integer variables, assigns an integer to each, and divides the larger number by the smaller number. Assign the result to a variable. Print out the result. Now change the larger number to a decimal. What happens? What corrections are needed?
 
5 Write a program that declares 2 double variables, assigns a number to each, and divides the larger by the smaller. Assign the result to a variable. Print out the result. Now, cast the result to an integer. Print out the result again.
 
6 Write a program that declares two integer variables, x, and y, and assigns 5 to x and 6 to y. Declare a variable q and assign y/x to it and print q. Now, cast y to a double and assign it to q. Print q again.
 
7 Write a program that declares a named constant and uses it in a calculation. Print the result.
 
8 Write a program where you create 3 variables that represent products at a cafe. The products could be beverages like coffee, cappuccino, espresso, green tea, etc. Assign prices to each product. Create 2 more variables called subtotal and totalSale and complete an “order” for 3 items of the first product, 4 items of the second product, and 2 items of the third product. Add them all together to calculate the subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale amount. Be sure to format the results to 2 decimal places.

 */

public class JavaBasicsClass {

	public static void main(String[] args) {

		int intVariableOne = 4;
		int intVariableTwo = 6;
		int intVariableSum = intVariableOne + intVariableTwo;

		double dblVariableOne = 7;
		double dblVariableTwo = 8;
		double dblVariableSum = dblVariableOne + dblVariableTwo;

		double taskThreeSum = intVariableTwo + dblVariableTwo;

		int taskFourResult = intVariableTwo / intVariableOne;
		double taskFourDbl = (double) intVariableTwo;

		double taskFiveResult = dblVariableTwo / dblVariableOne;
		int taskFiveInt = (int) taskFiveResult;

		int x = 5;
		int y = 6;
		double q = y / x;

		final int intConstant = 22;
		int taskSevenResult = intConstant + 23;

		double bagel = 1.20;
		double tea = 2.10;
		double coffee = 2.50;
		double subtotal = 0;
		final double SALES_TAX = 0.10;
		double totalSale = 0;

		// task 1
		System.out.println("task 1: " + intVariableSum);

		// task 2
		System.out.println("task 2: " + dblVariableSum);

		// task 3
		// It should come back as a double
		System.out.println("task 3: " + taskThreeSum);

		// task 4
		System.out.println("task 4: " + taskFourResult);

		// when trying to convert to double, an error occurs because you're trying to
		// step up from an int to a double
		// as a result, it asks to cast it back to an int
		taskFourResult = (int) (taskFourDbl / intVariableOne);
		System.out.println(taskFourResult);

		// task 5
		System.out.println("task 5: " + taskFiveResult);

		// this conversion was easier as it was stepping down from double to int rather
		// than up
		// as a result, the results comes back without error
		System.out.println(taskFiveInt);

		// task 6 (shown in class)
		// because we did not cast the integers to a double we lost the precision
		System.out.println("task 6: " + q);

		// however if we cast both x and y to a double then we preserve the precision
		q = (double) y / (double) x;
		System.out.println(q);

		// y is the whole number 6
		q = (double) y;
		// by casting y to a double we change it from the whole number 6 to a fractional
		// number 6.0
		System.out.println(q);

		// task 7
		System.out.println("task 7: " + "The Constant: " + intConstant);
		System.out.println("Constant + 23 = " + taskSevenResult);

		// task 8
		// problems i ran into: variable placement/variable order
		// because i initialized subtotal to = 0 and didn't have totalSale to update
		// along with subtotal in the task
		// the total sale was not being calculated properly
		subtotal = ((bagel * 3) + (tea * 4) + (coffee * 2));
		totalSale = subtotal + (subtotal * SALES_TAX);
		System.out.printf("task 8: " + "Your subtotal amounts to: " + "%,.2f \n", subtotal);
		System.out.printf("Your sales tax is: " + "%,.2f\n", (subtotal * SALES_TAX));
		System.out.printf("Your Grand Total is: " + "%,.2f\n", totalSale);

	}

}
