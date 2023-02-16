package com.java.feb16;

public class ArrayLibraryMain {
	// if you threw off the top of main, the exception would kill the program
	// entirely
	public static void main(String[] args) {

		ArrayLibrary al = new ArrayLibrary();
		int[] numbers = new int[10]; // helps to initialize your variables outside of scope for the sake for
										// exceptions

		// Initialize the array
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		// initialize the array with numbers from 1 to 10
		al.printArray(numbers, "Default initilization");

		// create a function that will insert a number into the array at a position
//		numbers = al.insertElement(numbers, 5, 11);
//		al.printArray(numbers, "After element insertion");
		try {
			numbers = al.insertElement(numbers, 15, 11);
			al.printArray(numbers, "After element insertion");

			// this is an example of how you can catch different types of exceptions
		} catch (NegativePositionException npe) {
			System.out.println("NEGATIVE POSITION EXCEPTION " + npe.getMessage());
			// 90% of the times you'll just use catch (Exception e)
		} // catch (Exception e) {
//			e.printStackTrace();
//		}		
		catch (PositionTooLargeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// this is where you would do cleanup (like scanner .close())
			// you want to close the thing gracefully
			// an example of what code goes here
			System.out.println("This code will be executed in either case no matter what");
		}

		// exception handling
//		try {
//			numbers = al.insertElement(numbers, 30, 11);
//		} catch ( Exception e) {
//			System.out.println("An exception occurred");
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}

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
