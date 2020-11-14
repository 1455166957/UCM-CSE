#include <igloo/igloo.h>
#include <SortedArray.h>

using namespace igloo;
Context(SortedArrayInsert) {
	Spec(InsertingIntoEmptyArray) {
		SortedArray expected;
		SortedArray actual;

		expected.capacity = 2;
		expected.count = 1;
		delete[] expected.data;
		expected.data = new long[2];
		expected.data[0] = 123;

		actual.insert(123);

		Assert::That(actual, Equals(expected));
	}
	Spec(InsertingTwoAcsendingElements) {
		SortedArray expected;
		SortedArray actual;

		expected.capacity = 4;
		expected.count = 2;
		delete[] expected.data;
		expected.data = new long[4];
		expected.data[0] = 222;
		expected.data[1] = 333;

		actual.insert(222);
		actual.insert(333);

		Assert::That(actual, Equals(expected));
	}
	Spec(InsertingTwoDescengingElements) {
		SortedArray expected;
		SortedArray actual;

		expected.capacity = 4;
		expected.count = 2;
		delete[] expected.data;
		expected.data = new long[4];
		expected.data[0] = 222;
		expected.data[1] = 333;

		actual.insert(333);
		actual.insert(222);

		Assert::That(actual, Equals(expected));
	}

	Spec(InsertingFourValuesWhereLastGoesIntoBeginnig) {
		SortedArray expected;
		SortedArray actual;

		expected.capacity = 8;
		expected.count = 4;
		delete[] expected.data;
		expected.data = new long[8];
		expected.data[0] = 0;
		expected.data[1] = 333;
		expected.data[2] = 444;
		expected.data[3] = 555;

		actual.insert(333);
		actual.insert(555);
		actual.insert(444);
		actual.insert(0);

		Assert::That(actual, Equals(expected));
	}

	Spec(InsertingRandomFourWhereLastGoesToEnd) {
		SortedArray expected;
		SortedArray actual;

		expected.capacity = 8;
		expected.count = 4;
		delete[] expected.data;
		expected.data = new long[8];
		expected.data[0] = 111;
		expected.data[1] = 333;
		expected.data[2] = 444;
		expected.data[3] = 999;

		actual.insert(444);
		actual.insert(333);
		actual.insert(111);
		actual.insert(999);

		Assert::That(actual, Equals(expected));
	}

	Spec(InsertingRandomFiveWhereLastGoesInMiddle) {
		SortedArray expected;
		SortedArray actual;

		expected.capacity = 8;
		expected.count = 5;
		delete[] expected.data;
		expected.data = new long[8];
		expected.data[0] = 111;
		expected.data[1] = 222;
		expected.data[2] = 333;
		expected.data[3] = 444;
		expected.data[4] = 555;

		actual.insert(222);
		actual.insert(555);
		actual.insert(111);
		actual.insert(444);
		actual.insert(333);

		Assert::That(actual, Equals(expected));
	}
};
int main() {
	// Run all the tests defined above
	return TestRunner::RunAllTests();
}
