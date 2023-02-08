package com.java.day3;

import java.util.ArrayList;
import java.util.List;

public class JavaDay3Feb8 {

	public static void main(String[] args) {
		// make a new function object that will do tasks
		JavaDay3Feb8 task = new JavaDay3Feb8();
		task.forLoopListExercise();
	}

	// remember: ctrl - shift - o will import classes that are not imported
	public void forLoopList() {
		List<String> list = new ArrayList<>();
		list.add("String 1");
		list.add("String 2");
		list.add("String 3");
	}

	public void forLoopListExercise() {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		
		for (Integer e : list) {
			System.out.println(e);

		}
	}
}
