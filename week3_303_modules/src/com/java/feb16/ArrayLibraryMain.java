package com.java.feb16;

public class ArrayLibraryMain {

	public static void main(String[] args) {

		ArrayLibrary al = new ArrayLibrary();
		int[] numbers = new int[10];

		// Initialize the array
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		// initialize the array with numbers from 1 to 10
		al.printArray(numbers, "Default initilization");

		// create a function that will insert a number into the array at a position
		numbers = al.insertElement(numbers, 5, 11);
		al.printArray(numbers, "After element insertion");

		// append 12 to the end of the array
		numbers = al.appendElement(numbers, 12);
		al.printArray(numbers, "After element append");

		// delete position 3 from the array
		numbers = al.deleteElement(numbers, 3);
		al.printArray(numbers, "After element delete");
		
		// find the position in the array of value 11
		int position = al.findPositionOfValue(numbers, 11);
		System.out.println("The position of value 11 is " + position);
		
		numbers = al.bubbleSort(numbers);
		al.printArray(numbers, "After sorting array");

	}

}
