package oop;

public class ModNCounter2 extends Counter {
	private int var;
	
	public ModNCounter2(int n) {
		var = n;
	}

	@Override
	public int value() {
		return myCount % var;
	}
}
