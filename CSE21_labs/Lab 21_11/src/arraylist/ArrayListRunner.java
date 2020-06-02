package arraylist;

import java.util.ArrayList;

public class ArrayListRunner {
	
	// Use this class to run your code

	public static void main(String[] args) {
		
		testArrayList();
		testTrackedArrayList();
	}

	
	
	public static void testArrayList() {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add ("a");
		words.add ("b");
		words.add ("c");
		words.remove ("b");
		words.add ("d");
		words.remove ("a");
		words.add ("e");
		words.remove ("b");
		words.add ("d");
		words.remove ("c");
		words.remove ("d");
		
		System.out.println(words.toString());
	}
	
	public static void testTrackedArrayList() {
		
		TrackedArrayList<String> words1 = new TrackedArrayList<String>();
		words1.add ("a");
		System.out.println(words1.maxSizeSoFar());
		words1.add ("b");
		System.out.println(words1.maxSizeSoFar());
		words1.add ("c");
		System.out.println(words1.maxSizeSoFar());
		words1.remove ("b");
		System.out.println(words1.maxSizeSoFar());
		words1.add ("d");
		System.out.println(words1.maxSizeSoFar());
		words1.remove ("a");
		System.out.println(words1.maxSizeSoFar());
		words1.add ("e");
		System.out.println(words1.maxSizeSoFar());
		words1.remove ("b");
		System.out.println(words1.maxSizeSoFar());
		words1.add ("d");
		System.out.println(words1.maxSizeSoFar());
		words1.remove ("c");
		System.out.println(words1.maxSizeSoFar());
		words1.remove ("d");
		System.out.println(words1.maxSizeSoFar());
		
		
		System.out.println(words1.toString());
	}
}
