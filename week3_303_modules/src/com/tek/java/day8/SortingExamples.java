package com.tek.java.day8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortingExamples {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(13);
		numbers.add(7);
		numbers.add(18);
		numbers.add(5);
		numbers.add(2);
		System.out.println("Before : " + numbers);
		// Sorting an ArrayList using Collections.sort() method
		// this is using a static utility method on the Collections object
		// collections is a set of tools
		// like Arrays.sort()
		Collections.sort(numbers);
		System.out.println("After : " + numbers);
		
		// this is using the sort function on the array list itself
		// what we are doing is passing in a comparator
		// a comparator implements a custom sort.
		numbers.sort(Comparator.reverseOrder());
		System.out.println("Reverse : " + numbers);

	}

}
