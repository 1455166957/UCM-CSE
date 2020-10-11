#include <igloo/igloo.h>
#include <Arrays.h>
#include <LinkedList.h>

using namespace igloo;

Context(DefaultConstructorTest){
	Spec(InitialSizeAndCounterTest){
		ResizableArray arr;

		Assert::That(arr.size, Equals(1));
		Assert::That(arr.counter, Equals(0));
	}
};

Context(CopyConstructorTest){
	Spec(EmptyArraysMatch){
		ResizableArray one;
		ResizableArray two;

		Assert::That(one == two, IsTrue());
	}
};

Context(AppendFunctionTest){
	Spec(AppendFiveToEmpty){
		// Hardcode expected value
		ResizableArray expected;
		expected.size = 2;
		expected.counter = 1;
		delete[] expected.data;
		expected.data = new int[2];
		expected.data[0] = 5;

		// Use append function to produce actual value
		ResizableArray actual;
		actual.append(5);

		// Actual should be the same as expected
		Assert::That(actual, Equals(expected));
	}

	Spec(AppendFiveAndSevenToEmpty){
		// Hardcode expected value
		ResizableArray expected;
		expected.size = 4;
		expected.counter = 2;
		delete[] expected.data;
		expected.data = new int[4];
		expected.data[0] = 5;
		expected.data[1] = 7;

		// Use append function to produce actual value
		ResizableArray actual;
		actual.append(5);
		actual.append(7);

		// Actual should be the same as expected
		Assert::That(actual, Equals(expected));
	}

	Spec(AppendFiveSevenAndOneToEmpty){
		// Hardcode expected value
		ResizableArray expected;
		expected.size = 4;
		expected.counter = 3;
		delete[] expected.data;
		expected.data = new int[4];
		expected.data[0] = 5;
		expected.data[1] = 7;
		expected.data[2] = 1;

		// Use append function to produce actual value
		ResizableArray actual;
		actual.append(5);
		actual.append(7);
		actual.append(1);

		// Actual should be the same as expected
		Assert::That(actual, Equals(expected));
	}
	Spec(AppendFiveSevenOneAndSixToEmpty){
		// Hardcode expected value
		ResizableArray expected;
		expected.size = 8;
		expected.counter = 4;
		delete[] expected.data;
		expected.data = new int[8];
		expected.data[0] = 5;
		expected.data[1] = 7;
		expected.data[2] = 1;
		expected.data[3] = 6;

		// Use append function to produce actual value
		ResizableArray actual;
		actual.append(5);
		actual.append(7);
		actual.append(1);
		actual.append(6);

		// Actual should be the same as expected
		Assert::That(actual, Equals(expected));
	}
};

Context(InsertFunctionTest){
	Spec(InsertFiveIntoEmptyAtPositionZero){
		ResizableArray expected;
		expected.append(5);

		ResizableArray actual;
		actual.insert(0, 5);

		Assert::That(actual, Equals(expected));
	}

	// Write some more tests here to convince us that your implementation is correct
	Spec(InsertFiveThenTen){     //testing for more than one value, that falls onto non-existent (yet) location
		ResizableArray expected;
		expected.append(5);
		expected.append(10);

		ResizableArray actual;
		actual.insert(0,5);
		actual.insert(1,10);

		Assert::That(actual, Equals(expected));
	}

	Spec(InsertFiveIntoNonExistentIndex) {  //Should fill everything precedent with 0's
		ResizableArray expected;
		expected.append(0);
		expected.append(0);
		expected.append(0);
		expected.append(5);

		ResizableArray actual;
		actual.insert(3,5);

		Assert::That(actual, Equals(expected));
	}

	Spec(InsertHundredIntoOccupiedSlot) { //Old value is expected to be shifted to the right
		ResizableArray expected;
		expected.append(0);
		expected.append(1);
		expected.append(2);
		expected.append(100);
		expected.append(3);
		expected.append(4);

		ResizableArray actual;
		actual.append(0);
		actual.append(1);
		actual.append(2);
		actual.append(3);
		actual.append(4);
		actual.insert(3, 100);

		Assert::That(actual, Equals(expected));
	}

};

Context(LinkedListTest) {
	Spec(InsertIntoOccupiedSlot) { //Should shift to the right
		LinkedList expected;
		expected.append(0);
		expected.append(1);
		expected.append(111);
		expected.append(2);
		expected.append(3);

		LinkedList actual;
		actual.append(0);
		actual.append(1);
		actual.append(2);
		actual.append(3);

		actual.insert(2, 111);
		Assert::That(actual, Equals(expected));
	}

	Spec(InsertIntoFarSlot) { //Should fill everything precedent with 0's
		LinkedList expected;
		expected.append(0);
		expected.append(1);
		expected.append(2);
		expected.append(3);
		expected.append(0);
		expected.append(0);
		expected.append(0);
		expected.append(0);
		expected.append(111);

		LinkedList actual;
		actual.append(0);
		actual.append(1);
		actual.append(2);
		actual.append(3);

		actual.insert(8, 111);
		Assert::That(actual, Equals(expected));
	}

	Spec(InsertIntoSubsequentSlot) { //Should behave like append
		LinkedList expected;
		expected.append(0);
		expected.append(1);
		expected.append(2);
		expected.append(3);
		expected.append(111);

		LinkedList actual;
		actual.append(0);
		actual.append(1);
		actual.append(2);
		actual.append(3);

		actual.insert(4, 111);
		Assert::That(actual, Equals(expected));
	}

	Spec(InsertIntoZeroIndex) {
		LinkedList expected;
		expected.append(111);
		expected.append(0);
		expected.append(1);
		expected.append(2);
		expected.append(3);

		LinkedList actual;
		actual.append(0);
		actual.append(1);
		actual.append(2);
		actual.append(3);

		actual.insert(0, 111);
		Assert::That(actual, Equals(expected));
	}
};


int main() {
	// Run all the tests defined above
	return TestRunner::RunAllTests();
}
