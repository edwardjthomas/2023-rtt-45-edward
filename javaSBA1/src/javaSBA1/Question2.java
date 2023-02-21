package javaSBA1;

public class Question2 {

	// you have to make two classes
	// one is cricket / one is football
	// football is gonna need something cricket ain't got
	// inheritance?
	
	// actual implementation of some of these lines are only two or four
	
	// question 2 also has an interface
	// obfuscate something about a array?

	// position : 0 1 2 3 4 5
	// values : a b c d e f

	// assume that the array is already initialized and is filled with -1 or whatever that means
	
	// we lack a harness to run all of these functions
	// does that mean for us to creating something that can trigger said methods?

	// they are going to give you the array size
	private static final int ARRAY_SIZE = 5;

	private int[] array;

	public static void main(String[] args) {
		Question2 q2 = new Question2();
		
		// initialize this entire array to a value ... -1 (last placement i thought it was at)
		// we could make a for loop down to set the position -1
		int[] avg = { 1, 2, 3, 4, 5, 6, 7 };
		q2.calculateAverage(avg);
		
		q2.setValue(4);
		// print first message value
		
		q2.setValue(5);
		// print first message value
		
		q2.setValue(4);
		// print 2nd message because its already been changed
		
		q2.move(50, 3);
		// print first message
		
		q2.move(30, 3);
		// print 2nd message
		
		q2.move(30, 4);
		// print 2nd message
	}

	Question2() {
		// we need to make a 1 based data structure for an array of size 5
		// an array is 0 based so when we need 5 elements they go from 0 to 4
		// however since we are 1 based .. how many elements do we need? (five elements
		// going from 1to5)
		// it gotta be six total size array

		
		// *********************************** THIS IS IMPORTANT TO ADD 1 to what ever they give you or it will array index out of bound
		
		// the key to this is to ignore the 0th element of the array
		int[] arr = new int[ARRAY_SIZE + 1];

		// initialize this entire array to a value ... -1 (placement eric put it)


	}

	// this will be in an interface
	// and will be the exact same implementation in both classes
	// add by the elements then divide by the total elements
	public void calculateAverage(int[] arr) {
		// calculate the average
		// print out a message using system.out.format of the average with
		// decimal format this to show 2 places right of the decimal ( using %.2f )
		// include a new line character at the end of the message
	}
	
	// this will be in an interface
	// and will be the exact same implementation in both classes
	public  void setValue(int index) {
		// this will be using the class level variable
		// if the value at array[index] == 1 then print a message saying that you set the
		// value to 1
		// otherwise print a message saying that it was already changed
	}

	// this will be an extra function in one of the 2 classes
	public void move(int value, int id) {
		// if the value at array[id] == -1 then print a message saying "Value with id: {id} is moved to {value}" and set the value to 1
		// otherwise print a message saying "Value is already -1"
	}
}
