package com.java.day2;

public class JavaDay2Feb7Notes {

	public static void main(String[] args) {

		// wrapper class examples slide 6
//		byte b = 100;
//		Byte bb = 100;
//		short s = 100;
//		Short ss = 100;
//		int i = 100;  // primitive data type
//		Integer ii = 100;  // literal method
//		Integer iii = new Integer(1000);  // new operator
//		long l = 100l;
//		Long ll = 100l;
//		float f = 100.0f;
//		Float ff = 21.24f;
//		double d = 546.32;
//		Double dd = 545.255;
//		char ch = 'a';
//		Character cha = 'a';
//		boolean bo = true;
//		Boolean boo = true;

		// --------AutoBoxing Examples--- slide 7
//		int a = 20;
//		Integer convertintoInteger = a;
//
//		char c = 'A';
//		Character convertintoChar = c;
//
//		double d = 565.23;
//		Double convertintoDouble = d ;
//
//		// ---- UnBoxing Example------
//		Integer i = 56;
//		int ii = i;  
//
//		Character c = 'a';
//		char ch = c;
//
//		Double d = 2563.32;
//		double dd = d;

		// Wrapper character class
//		Character letter = new Character('g');
//		Character num = new Character('7');
//		System.out.println(letter);
//		System.out.println(num);
//
//		// primitive char data type
//		char letter_ch = 'g';
//		char num_ch = '7';
//		System.out.println(letter_ch);
//		System.out.println(num_ch);

		// methods in the character class slide 13
//	       Character letter = 'A';
//	       System.out.println(letter);
//	       Character asciNumber = 97;
//	       System.out.println(asciNumber);
//	       Character uninumber = '\u0031';
//	       Character uninumber2 = '\u0032';
//	       System.out.println(uninumber);
//	       System.out.println(uninumber2);
//	       System.out.println("======compareTo========");
//	       Character Obj1 = '2';
//	       Character Obj2 = '2';
//	       int result =    Obj1.compareTo(Obj2);
//	       System.out.println(result);
//	       System.out.println("----equals() -------");
//	       boolean  result2 =    Obj1.equals(Obj2);
//	       System.out.println(result2);
//	       System.out.println("----isletter() -------");
//	       // isletter method determines wheather the specified char value is letter
//	       System.out.println(Obj1.isLetter(Obj2));
//	       System.out.println("----isDiggit() -------");
//	       // isDiggit() determin whether the specified char value is a digit
//	       System.out.println( Obj2.isDigit(Obj1));
//	       Obj1.valueOf('A');   // Obj1 = 'A'
//	       System.out.println("----compareTo-------");
//	       Character a = 'B';
//	       Character aa = 'B';
//	       System.out.println(a == aa);
//	       int rs =  a.compareTo(aa);
//	       System.out.println(rs);

//		public class OnewayifDemo {
//			   public static void main(String[] args) {
//
//			int radius = 10;
//			if (radius >= 0) {
//			  double area = radius * radius * PI;
//			  System.out.println("The area of a circle of "     
//			    + "radius " + radius + " is " + area);
//			   } // close if body
//			  } // close main method body
//			} // close call body

//		public class OnewayDemo{
//			   public static void main(String[] args) {
//			int mark = 80;
//			if (mark >= 80) {
//			   System.out.println("Well Done!");
//			   System.out.println("Keep it up!");
//			  }  // close if body
//			System.out.println("Life goes on!");
//			  } // close main method body
//			} // close call body

//		if (control-expression / boolean expression) { 
//			  statement(s)-for-the-true-case;
//			}
//			else {
//			  statement(s)-for-the-false-case;
//			}

//		public class ifelseDemo {
//			   public static void main(String[] args) {
//			int radius = 10;
//			if (radius >= 0) {   
//				double area = radius * radius * 3.14159;
//			 	System.out.println("The area of a circle of radius" +  
//					radius + " is " + area);
//			} // close if body
//			else {
//			  System.out.println("A negative radius is not possible.");
//			   } // close else body
//			  } // close main body
//			} // close class body

//		if ( condition-expression-1 ) {
//		      statement(s);
//		  }
//		  else if ( condition-expression-2 ) {
//		       statement(s);
//		  }
//		  else if ( condition-expression-3 ) {
//		       statement(s);
//		  }
//		  else {
//		       statement(s);
//		  }

//		public class BMI {
//			   public static void main(String args[]) {
//			       Scanner sc = new Scanner(System.in);
//			       System.out.print("Input weight in kilogram: ");
//			       double weight = sc.nextDouble();
//			       System.out.print("\nInput height in meters: ");
//			       double height = sc.nextDouble();
//			       // calculate bmi
//			       double BMI = weight / (height * height);
//			       // check range
//			       if(BMI < 18.5)
//			           System.out.println("Under weight");
//			       else if(BMI >= 18.5 && BMI < 25)
//			           System.out.println("Normal");
//			       else if(BMI >=  25 && BMI < 30)
//			           System.out.println("Overweight");
//			       else
//			           System.out.println("Obese");
//			       System.out.print("\nThe Body Mass Index (BMI) is " + BMI + " kg/m2");
//			   }
//			}

//		public class LeapYear {
//			   public static void main(String[] args){
//			      int year;
//			      System.out.println("Enter an Year :: ");
//			      Scanner sc = new Scanner(System.in);
//			      year = sc.nextInt();
//			      if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
//			         System.out.println("Specified year is a leap year");
//			      else
//			         System.out.println("Specified year is not a leap year");
//			   }

//			   switch (expression / variable ) {
//			   case value1:
//			     // code
//			     break;
//			   
//			   case value2:
//			     // code
//			     break;
//			   
//			   ...
//			   ...
//			   
//			   default:
//			     // default statements
//			   }

//			   public static void main(String args[])
//			   {
//			      String output;
//			      // grade is a value 0 - 100
//			      int grade = 50;
//			      switch (grade / 10)
//			      {
//			          case 10: output = "Wow!; ";   break;
//			          case 9: output = "Excellent!"; break;
//			          case 8: output = "Very Good!"; break;
//			          case 7: output = "Good!"; break;
//			          default: output = "Keep trying!"; break;
//			      }
//			      System.out.println(output);
//			   }

//			   public class switchcaseDemo{
//				   public static void main(String[] args) {
//				       int expression = 9;
//				     
//				     switch(expression) {
//				       case 2:
//				         System.out.println("Small Size");
//				         break;
//
//				       case 3:
//				         System.out.println("Large Size");
//				         break;
//				             
//				       // default case
//				       default:
//				         System.out.println("Unknown Size");
//				     }
//				   }
//				 }

//			   public static void main(String[] args)
//			   {
//			      //Declaring a variable for switch expression
//			      char alphabet = 'b';
//			      switch(alphabet) //Switch expression
//			      {
//			          //Case statements
//			          case 'a':
//			              System.out.println("This is character 'a' ");
//			              break;
//			          case 'b':
//			              System.out.println("This is character 'b' ");
//			              break;
//			          case 'c':
//			              System.out.println("This is character 'c' ");
//			              break;
//			          //Default case statement
//			          default: System.out.println("Please enter valid input");
//			      }
//			   }

//			   enum Cars {
//			       BMW,
//			       JEEP,
//			       AUDI,
//			       VOLKSWAGON,
//			       NANO,
//			       FIAT;
//			   }
//			   public static void main(String args[]) {
//			       // Declaring Enum variable
//			       Cars c;
//			       c = Cars.AUDI;
//			       // Switch keyword
//			       switch (c) {
//			           // Case statements
//			           case BMW:
//			               System.out.println("You choose BMW !");
//			               break;
//			           case JEEP:
//			               System.out.println("You choose JEEP !");
//			               break;
//			           case AUDI:
//			        	     System.out.println("You choose AUDI !");
//			        	       break;
//			        	   case VOLKSWAGON:
//			        	     System.out.println("You choose VOLKSWAGON !");
//			        	     break;
//			        	   case NANO:
//			        	     System.out.println("You choose NANO !");
//			        	     break;
//			        	   case FIAT:
//			        	     System.out.println("You choose FIAT !");
//			        	    default:
//			        	     System.out.println("NEW BRAND'S CAR.");
//			        	       break;
//			        	       }
//			        	   }
//			        	}

//		int year = 2022;
//		switch (year % 12) {
//		case 0:
//			System.out.println("monkey");
//			break;
//		case 1:
//			System.out.println("rooster");
//			break;
//		case 2:
//			System.out.println("dog");
//			break;
//		case 3:
//			System.out.println("pig");
//			break;
//		case 4:
//			System.out.println("rat");
//			break;
//		case 5:
//			System.out.println("ox");
//			break;
//		case 6:
//			System.out.println("tiger");
//			break;
//		case 7:
//			System.out.println("rabbit");
//			break;
//		case 8:
//			System.out.println("dragon");
//			break;
//		case 9:
//			System.out.println("snake");
//			break;
//		case 10:
//			System.out.println("horse");
//			break;
//		case 11:
//			System.out.println("sheep");
	}
}
