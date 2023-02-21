package javaHomeWork.Loops;

/* 303.3.1
Question 1: Print a Multiplication Table
Write a program that uses nested for loops to print a multiplication table.





Question 2: Find the Greatest Common Divisor
Write a program that prompts the user to enter two positive integers, and find their greatest common divisor (GCD).
Examples:
Enter 2 and 4. The gcd is 2. 
Enter 16 and 24.  The gcd is 8. 
How do you find the gcd? 
Name the two input integers n1 and n2. 
You know number 1 is a common divisor, but it may not be the gcd. 
Check whether k (for k = 2, 3, 4, and so on) is a common divisor for n1 and n2, until k is greater than n1 or n2.







Question 3: Predict Future Tuition
Suppose the tuition for a university is $10,000 for the current year and increases by 7 percent every year. 
In how many years will the tuition be doubled?

 */

public class Loops {

	public static void main(String[] args) {
		// task 1
		int multiple1 = 0;
		int multiple2 = 0;
		for (multiple1 = 1; multiple1 <= 12; ++multiple1) {
			for (multiple2 = 1; multiple2 <= 12; ++multiple2) {
				System.out.printf("%4d", multiple1 * multiple2);
			}
			System.out.println();
		}		

		// task 2
		int n1 = 16;
		int n2 = 24;
		int k = 1;
		int result = 0;
		{
			
			for(k = 1; k <= n1 || k <= n2; k++) {
				if(n1%k == 0 && n2%k == 0) {
					result = k;
				}
			}
			System.out.println("GCD of " + n1 + " & " + n2 + " is " + result);
			System.out.println();
		}

		// task 3
		double tuition = 10000.00;
		double tuitionStart = 10000.00;
		final double INTEREST = 1.07;
		int years = 0;
		for (years = 0; tuition <= tuitionStart * 2; years++)
		{
		  tuition = INTEREST * tuition;
		}
		System.out.println("It takes " + years + " years for tuition to double");
		System.out.println();


	}
}
