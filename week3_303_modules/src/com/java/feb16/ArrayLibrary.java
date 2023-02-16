package com.java.feb16;

import java.util.Arrays;

public class ArrayLibrary {

	public void printArray(int[] arr, String message) {
		System.out.println(message + "\t = " + Arrays.toString(arr));
	}

	public int[] insertElement(int[] arr, int position, int value) throws Exception, PositionTooLargeException, NegativePositionException {
		// first thing's first when you enter a function is to test your inputs
		if (position < 0) {
			throw new NegativePositionException("Position must be greater than 0");
		}
		
//		if (position >= arr.length ) {
//			throw new Exception("Position must be less than " + arr.length);
//		}
		if (position >= arr.length ) {
			throw new PositionTooLargeException("Position must be less than " + arr.length);
		}
		
		//		// create new array
//		int[] copy = new int[arr.length + 1];
//
//		// copy all elements from arr into the new copy
//		for (int i = 0; i < arr.length; i++) {
//			copy[i] = arr[i];
//		}

		int[] copy = appendElement(arr, 0);
		// printArray(copy, "Copy Initialized to");

		// move all elements in the array starting
		// copy [i+1] = copy[i]
		for (int i = position; i < arr.length; i++) {
			copy[i + 1] = arr[i];
		}
		// printArray(copy, "Copy Shifted Right");

		// set arr[position] = number
		copy[position] = value;
		// printArray(copy, "newValue set on copy");

		// return the new array
		return copy;
	}

	public int[] appendElement(int[] arr, int value) {
		int[] copy = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}

		copy[arr.length] = value;

		return copy;
	}

	public int[] deleteElement(int arr[], int index) {
//		int[] copy = new int[arr.length - 1];
//		for (int i = 0, n = 0; i < arr.length; i++) {
//			if (i == index) {
//				continue;
//			}
//			copy[n++] = arr[i];

		// eric's way reduces complexity
		for (int i = index + 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		// printArray(arr, "Array shifted left");

		int[] copy = new int[arr.length - 1];

		for (int i = 0; i < copy.length; i++) {
			copy[i] = arr[i];
		}

		return copy;
	}

	public int[] bubbleSort(int arr[]) {
		// nested for loops?
		// 1- outer loop that will move across the entire array
		// 2- inner loop that moves across the entire array
		// 3- compare element at arr[inner] with arr[inner+1]
		// 4- if arr[inner] < arr[inner+1] then swap the elements
		// 5- use a temp variable to store one value
		// 6- move the other value
		// 7 - put the temp value into the one you just moved
		// 8 - return the array (we don't have to make a copy of the array)

		//int temp = 0; // it's better for the sake of scope to keep temp inside the if statement

		for (int outer = 0; outer < arr.length; outer++) {
			for (int inner = 0; inner < arr.length - 1; inner++) {
				if (arr[inner] < arr[inner + 1]) {
					int temp = arr[inner];
					arr[inner] = arr[inner + 1];
					arr[inner + 1] = temp;
				}
			}
		}

		return arr;
	}

	public int findPositionOfValue(int arr[], int value) {
		// find the position of the incoming value
		// if the value is not found then return -1
		// return the first element found

//		for (int i = 0 ; i < arr.length ; i++ ) {
//			if (arr[i] == value) {
//				value = arr[i];  //this is where we messed up at in not bring position into equation. we needed to just return i if we were going this way
//				break;
//			}
//			
//		}

		int position = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				position = i + 1;
				break;
			}
		}

		return position;
	}
}
