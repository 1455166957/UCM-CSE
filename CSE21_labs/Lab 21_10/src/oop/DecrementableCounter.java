package oop;

public class DecrementableCounter extends Counter {
	public DecrementableCounter(int n) {
		myCount = n;
	}
	
	public void decrement() {
		if (myCount > 0)
			myCount--;
	}
}
