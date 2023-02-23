package week4_303_modules;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Larry");
		names.add("Steven");
		names.add("Eric");
		names.add("Jessica");
		names.add("Ellen");

		// 1) sort the original names list by length of name using a stream.
		names.sort(Comparator.comparingInt(String::length)); // the :: still fucks with me
		System.out.print(String.join("\n", names) + "\n");

		System.out.println("==========================");

		// 2) when the length is the same then sort secondary by alphabetically
		names.sort(Comparator.comparingInt(String::length).thenComparing(String::toString)); // using :: to call
																								// toString
		names.sort(Comparator.comparingInt(String::length).thenComparing(x -> x.toLowerCase())); // alternate method
																									// using lambda call
																									// to make it
																									// lowercase
		// doesn't work, for some reason, though.
		System.out.print(String.join("\n", names) + "\n");

		System.out.println("==========================");

		List<String> sortedList = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.print(String.join("\n", sortedList) + "\n");
		System.out.println("==========================");

		// remove all names from the list that contain an "n"
		sortedList.removeIf(name -> name.contains("n"));
		System.out.print(String.join("\n", sortedList) + "\n");

	}
}