package com.java.day2;

import java.util.Scanner;

/* 303.2.2  
1.Write a program that declares 1 integer variable x, and then assigns 7 to it. Write an if statement to print out “Less than 10” if x is less than 10. Change x to equal 15, and notice the result (console should not display anything).
 
2. Write a program that declares 1 integer variable x, and then assigns 7 to it. Write an if-else statement that prints out “Less than 10” if x is less than 10, and “Greater than 10” if x is greater than 10. Change x to 15 and notice the result.
 
3. Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else-if statement that prints out “Less than 10” if x is less than 10; “Between 10 and 20” if x is greater than 10 but less than 20, and “Greater than or equal to 20” if x is greater than or equal to 20. Change x to 50 and notice the result.
 
4. Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else statement that prints “Out of range” if the number is less than 10 or greater than 20 and prints “In range” if the number is between 10 and 20 (including equal to 10 or 20). Change x to 5 and notice the result.
 
5. Write a program that uses if-else-if statements to print out grades A, B, C, D, F according to the following criteria:
A: 90-100
B: 80-89
C: 70-79
D: 60-69
F: <60
Use the Scanner class to accept a number score from the user to determine the letter grade. Print out “Score out of range” if the score is less than 0 or greater than 100.
 
6. Write a program that accepts an integer between 1 and 7 from the user. Use a switch statement to print out the corresponding weekday. Print “Out of range” if the number is less than 1 or greater than 7. Do not forget to include “break” statements in each of your cases.


7. Create a program that lets the users input their filing status and income. Display how much tax the user would have to pay according to status and income.
The U.S. federal personal income tax is calculated based on the filing status and taxable income. 
There are four filing statuses: Single, Married Filing Jointly, Married Filing Separately, and Head of Household. 
The tax rates for 2009 are shown below.
*/

public class ControlFlowConditionalStatements {

	public static void main(String[] args) {
		// make a new function object that will do tasks
		ControlFlowConditionalStatements task = new ControlFlowConditionalStatements();

		task.task1();
		task.task2();
		task.task3();
		task.task4();
		// task.task5();
		// task.task6();
		task.task7();

	}

	// task 1
	public void task1() {
		int x = 7;
		if (x < 10) {
			System.out.println("Less than 10");
		}
	}

	// task 2
	public void task2() {
		int x = 15;
		if (x < 10) {
			System.out.println("Less than 10");
		} else {
			System.out.println("Greater than 10");
		}
	}

	// task 3
	public void task3() {
		int x = 50;
		if (x < 10) {
			System.out.println("Less than 10");
		} else if (x > 10 && x < 20) {
			System.out.println("Between 10 and 20");
		} else if (x >= 20) {
			System.out.println("Greater than or equal to 20");
		}
	}

	public void task4() {
		int x = 5;
		if (x < 10 || x > 20) {
			System.out.println("Out of range");
		} else if (x >= 10 && x <= 20) {
			System.out.println("In range");
		}
	}

	public void task5() {
		Scanner grade = new Scanner(System.in);
		System.out.println("What is your grade?");
		int inputGrade = grade.nextInt();

		// remember that order of conditionals are a thing as well
		// we had to switch the placement of out of range and grade f conditions to meet
		// requirements

		if (inputGrade == 100 || inputGrade >= 90) {
			System.out.println("Grade: A");
		} else if (inputGrade == 89 || inputGrade >= 80) {
			System.out.println("Grade: B");
		} else if (inputGrade == 79 || inputGrade >= 70) {
			System.out.println("Grade: C");
		} else if (inputGrade == 69 || inputGrade >= 60) {
			System.out.println("Grade: D");
		} else if (inputGrade < 0 || inputGrade > 100) {
			System.out.println("Score out of range");
		} else if (inputGrade == 59 || inputGrade <= 50) {
			System.out.println("Grade: F");
		}
	}

	public void task6() {
		Scanner day = new Scanner(System.in);
		System.out.println("Input a number thru 1-7: ");
		int inputDay = day.nextInt();
		switch (inputDay) {
		case 1:
			System.out.println("Sunday");
			break;
		case 2:
			System.out.println("Monday");
			break;
		case 3:
			System.out.println("Tuesday");
			break;
		case 4:
			System.out.println("Wednesday");
			break;
		case 5:
			System.out.println("Thursday");
			break;
		case 6:
			System.out.println("Friday");
			break;
		case 7:
			System.out.println("Saturday");
			break;
		default:
			System.out.println("Out of range");
		}
	}

	public void task7() {
		Scanner taxes = new Scanner(System.in);
		System.out.println("What is your filing status? ");
		String inputStatus = taxes.nextLine();
		System.out.println("What is your income? ");
		int inputIncome = taxes.nextInt();

		switch (inputStatus) {
		case "Single":
			if (inputIncome >= 0 && inputIncome <= 8350) {
				System.out.println("Marginal Tax Rate: 10%");
			} else if (inputIncome >= 8351 && inputIncome <= 33950) {
				System.out.println("Marginal Tax Rate: 15%");
			} else if (inputIncome >= 33951 && inputIncome <= 82250) {
				System.out.println("Marginal Tax Rate: 25%");
			} else if (inputIncome >= 82251 && inputIncome <= 171550) {
				System.out.println("Marginal Tax Rate: 28%");
			} else if (inputIncome >= 171551 && inputIncome <= 372950) {
				System.out.println("Marginal Tax Rate: 33%");
			} else if (inputIncome >= 372951) {
				System.out.println("Marginal Tax Rate: 35%");
			} else {
				System.out.println("Please input a valid income.");
			} break;
			
		case "Married Filing Jointly":
			if (inputIncome >= 0 && inputIncome <= 16700) {
				System.out.println("Marginal Tax Rate: 10%");
			} else if (inputIncome >= 16701 && inputIncome <= 67900) {
				System.out.println("Marginal Tax Rate: 15%");
			} else if (inputIncome >= 67901 && inputIncome <= 137050) {
				System.out.println("Marginal Tax Rate: 25%");
			} else if (inputIncome >= 137051 && inputIncome <= 208850) {
				System.out.println("Marginal Tax Rate: 28%");
			} else if (inputIncome >= 208851 && inputIncome <= 372950) {
				System.out.println("Marginal Tax Rate: 33%");
			} else if (inputIncome >= 372951) {
				System.out.println("Marginal Tax Rate: 35%");
			} else {
				System.out.println("Please input a valid income.");
			} break;
			
		case "Married Filing Separately":
			if (inputIncome >= 0 && inputIncome <= 8350) {
				System.out.println("Marginal Tax Rate: 10%");
			} else if (inputIncome >= 8351 && inputIncome <= 33950) {
				System.out.println("Marginal Tax Rate: 15%");
			} else if (inputIncome >= 33951 && inputIncome <= 68525) {
				System.out.println("Marginal Tax Rate: 25%");
			} else if (inputIncome >= 68526 && inputIncome <= 104425) {
				System.out.println("Marginal Tax Rate: 28%");
			} else if (inputIncome >= 104426 && inputIncome <= 186475) {
				System.out.println("Marginal Tax Rate: 33%");
			} else if (inputIncome >= 186476) {
				System.out.println("Marginal Tax Rate: 35%");
			} else {
				System.out.println("Please input a valid income.");
			} break;
			
		case "Head of Household":
			if (inputIncome >= 0 && inputIncome <= 11950) {
				System.out.println("Marginal Tax Rate: 10%");
			} else if (inputIncome >= 11951 && inputIncome <= 45500) {
				System.out.println("Marginal Tax Rate: 15%");
			} else if (inputIncome >= 45501 && inputIncome <= 117450) {
				System.out.println("Marginal Tax Rate: 25%");
			} else if (inputIncome >= 117451 && inputIncome <= 190200) {
				System.out.println("Marginal Tax Rate: 28%");
			} else if (inputIncome >= 190201 && inputIncome <= 372950) {
				System.out.println("Marginal Tax Rate: 33%");
			} else if (inputIncome >= 372951) {
				System.out.println("Marginal Tax Rate: 35%");
			} else {
				System.out.println("Please input a valid income.");
			} break;
			
		default:
			System.out.println("Please input a valid status.");
		}
	}

}
