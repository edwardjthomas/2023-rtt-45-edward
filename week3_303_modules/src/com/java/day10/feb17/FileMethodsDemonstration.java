package com.java.day10.feb17;

import java.io.File;

public class FileMethodsDemonstration {
	public static void main(String args[]) {
		String path = ".\\src\\com\\java\\day10\\feb17\\testingFile.txt";
		File f = new File(path);
		System.out.println("File Name: " + f.getName());
		System.out.println("File Path: " + f.getPath());
		System.out.println("Is path absolute: " + f.isAbsolute());
		System.out.println("Return Absolute path of the File " + f.getAbsolutePath());
		System.out.println("Return Parent folder of the given File " + f.getParent());
		System.out.println("File is Exist " + f.exists());
		System.out.println(f.exists() ? "Yes file exists" : "file does not exist");
		if (f.exists()) // return true or False
		{
			System.out.println("File is Found");
			System.out.println("IS file Readable " + f.canRead());
			System.out.println("IS file Writeable " + f.canWrite());
			System.out.println("File size in a bytes " + f.length()); // file size in byte
		}
	}
}
