package com.tek.example1;

public class TypeCastingExample {

	public static void main(String[] args) {

		   byte i = 40;
		   // No casting needed for below conversion
		   short j = i;
		   int k = j;
		   long l = k;
		   float m = l;
		   double n = m;
		   System.out.println("byte value : "+i);
		   System.out.println("short value : "+j);
		   System.out.println("int value : "+k);
		   System.out.println("long value : "+l);
		   System.out.println("float value : "+m);
		   System.out.println("double value : "+n);
		   // s =  short(k);  // Not Allowed - narrowing
		   // c = (char)(k); // Not Allowed - narrowing
		   float f = 1.5e3f;
		   k = (int)f; // Explicit - ok
		   // k = f // Not Allowed - narrowing
				   
	}

}
