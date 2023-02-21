package com.java.day10.feb17;

import java.io.*;

public class FileClassDemo {
	public static void main(String[] args) {
		try {
			File f = new File(".\\src\\com\\java\\day10\\feb17\\Datafile.txt");
			if (f.createNewFile()) {
				System.out.println("New File created!");
			} else {
				System.out.println("The file already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
