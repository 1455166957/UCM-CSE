package oop;

public class Runner {

	public static void main(String[] args) {
		testCounter();

		testCounter7Statements();

		testModNCounter2();

		testDecrementableCounter();

		testSeasonCounter();
	}

	
	public static void testCounter() {
		System.out.println("-- Testing Counter");

		Counter c = new Counter();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current value: " + c.value());

	}

	
	public static void testCounter7Statements() {
		Counter c = new Counter();
		System.out.println("-- Testing 7 statements");
		// include exactly 7 increment() and reset() statements below
		c.increment();
		c.increment();
		c.increment();
		c.reset();
		c.increment();
		c.increment();
		c.increment();
		
		System.out.println("Current value: " + c.value());
	}
	
	
	public static void testModNCounter2() {
		ModNCounter2 m1 = new ModNCounter2(2);
		ModNCounter2 m2 = new ModNCounter2(5);
		System.out.println("\n-- Testing ModNCounter2");
		for (int i = 0; i < 6; i++) {
			System.out.println("Current value: " + m1.value());
			System.out.println("Current value: " + m2.value());
			m1.increment();
			m2.increment();
		}
	}
	
	
	public static void testDecrementableCounter() {
		DecrementableCounter d = new DecrementableCounter(5);
		System.out.println("\n-- Testing DecrementableCounter");
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Current value: " + d.value());
			d.decrement();
		}
	}
	
	
	public static void testSeasonCounter() {
		SeasonCounter s = new SeasonCounter();
		System.out.println("\n--Testing SeasonCounter");
		for(int i = 0; i < 6; i++) {
			System.out.println("Current value of myCount " + s.value() + " is " + s.toString());
			s.increment();
		}
	}

}
