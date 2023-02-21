package javaHomeWork.Array;

import java.util.Arrays;
import java.util.Scanner; 

/* 303.3.2
Write a program that creates an array of integers with a length of 3. Assign the values 1, 2, and 3 to the indexes. Print out each array element.

Write a program that returns the middle element in an array. Give the following values to the integer array: {13, 5, 7, 68, 2} and produce the following output: 7
 
Write a program that creates an array of String type and initializes it with the strings “red”, “green”, “blue” and “yellow”. Print out the array length. Make a copy using the clone( ) method. Use the Arrays.toString( ) method on the new array to verify that the original array was copied.
 
Write a program that creates an integer array with 5 elements (i.e., numbers). The numbers can be any integers.  Print out the value at the first index and the last index using length - 1 as the index. Now try printing the value at index = length ( e.g., myArray[myArray.length ] ).  Notice the type of exception which is produced. Now try to assign a value to the array index 5. You should get the same type of exception.
 
Write a program where you create an integer array with a length of 5. Loop through the array and assign the value of the loop control variable (e.g., i) to the corresponding index in the array.
 
Write a program where you create an integer array of 5 numbers. Loop through the array and assign the value of the loop control variable multiplied by 2 to the corresponding index in the array.
 
Write a program where you create an array of 5 elements. Loop through the array and print the value of each element, except for the middle (index 2) element.
 
Write a program that creates a String array of 5 elements and swaps the first element with the middle element without creating a new array.
 
Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}. Print the array in ascending order, and print the smallest and the largest element of the array. The output will look like the following:
Array in ascending order: 0, 1, 2, 4, 9, 13
The smallest number is 0
The biggest number is 13
 
Create an array that includes an integer, 3 strings, and 1 double. Print the array.


Write some Java code that asks the user how many favorite things they have. Based on their answer, you should create a String array of the correct size. Then ask the user to enter the things and store them in the array you created. Finally, print out the contents of the array.
Example

How many favorite things do you have?
7

Enter your thing: phone
Enter your thing: tv
Enter your thing: xbox
Enter your thing: wine
Enter your thing: beer
Enter your thing: sofa
Enter your thing: book
Your favorite  things are:
phone tv xbox wine beer sofa book

 */

public class Array {

	public static void main(String[] args) {

		// task 1
		int arr[] = { 1, 2, 3 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println("task1: " + arr[i]);
		}

		// task 2
		int arr2[] = { 13, 5, 7, 68, 2 };
		System.out.println("task2: " + arr2[arr2.length / 2]);

		// task 3
		String arr3[] = { "red", "green", "blue", "yellow" };
		System.out.println("task3: " + arr3.length);
		String arr3Copy[] = arr3.clone();
		System.out.println("task3: " + Arrays.toString(arr3Copy));

		// task 4
		int arr4[] = { 2, 4, 6, 8, 10 };
		System.out.println("task4: " + arr4[0]);
		System.out.println("task4: " + arr4[arr4.length-1]);
		
		// task 5
		int arr5[] = { 2, 4, 6, 8, 10 };
		for (int i = 0; i < arr5.length; i++) {
			arr5[i] = i;
			System.out.println("task5: " + arr5[i]);
		}

		// task 6
		int arr6[] = { 2, 4, 6, 8, 10 };
		for (int i = 0; i < arr6.length; i++) {
			arr6[i] = i * 2;
			System.out.println("task6: " + arr6[i]);
		}
		
		// task 7
		int arr7[] = { 2, 4, 6, 8, 10 };
		System.out.println("task7: " + Arrays.toString(arr7));
		int temp = arr7[arr7.length/2];
		arr7[arr7.length/2] = arr7[0];
		arr7[0] = temp;
		System.out.println("task7: " + Arrays.toString(arr7));

		// task 8
		int arr8[] = { 4, 2, 9, 13, 1, 0 };
		Arrays.sort(arr8);
		System.out.println("task8: " + Arrays.toString(arr8));
		System.out.println("task8: Smallest number is " + arr8[0]);
		System.out.println("task8: Biggest number is " + arr8[arr8.length-1]);
		
		// task 9
		Object arr9[] = {8, "hi", "hello", "hey", 5.0};
		System.out.println("task9: " + Arrays.toString(arr9));

		// task 10
		Scanner task10input = new Scanner(System.in); // make the scanner
		System.out.println("task10: How many favorite things? ");
		
		Integer favThingsCount = task10input.nextInt(); // user puts in number
		task10input.nextLine();

		String arr10[] = new String[favThingsCount];
		for (int i = 0; i < arr10.length; ++i) {
			System.out.println("task10: what's your favorite thing for " + i + "?");
			arr10[i] = task10input.nextLine();
		}
		
		System.out.println("task10: your favorite things are :" + Arrays.toString(arr10));
		


	}

}
