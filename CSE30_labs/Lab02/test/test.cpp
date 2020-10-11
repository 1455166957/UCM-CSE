#include <igloo/igloo.h>
#include <MemoryStuff.h>

using namespace igloo;

Context(DecimalToHexTest){
	Spec(Seven_07){
		// Check to see if we actually add a 0 in front of a single digit result
		Assert::That(decToHex(7), Equals("07"));
	}

	Spec(Fifteen_0F){
		// Check to see if hex symbols A-F are in upper case
		Assert::That(decToHex(15), Equals("0F"));
	}
		//Those two tests above only verify upper cases and 0's
		//None of them really verify large and diverse numbers

	Spec(NinetyNine_63){
		Assert::That(decToHex(99), Equals("63"));
	}

	Spec(NinetyNineTwenty_26C0){
		Assert::That(decToHex(9920), Equals("26C0"));
	}

	Spec(Zero){
		Assert::That(decToHex(0), Equals("00"));
	}

};

Context(MemoryContentFunctionTest){
	Spec(ThreeHundredFourteen_00_00_01_3A){
		Assert::That(memoryContents(314), Equals("3A:01:00:00"));
	}

	// Your code here
	Spec(TwoThousandTwenty_What){
		Assert::That(memoryContents(2020), Equals("E4:07:00:00"));
		// Put in the 4 correct values above in place of the xx
	}

	Spec(Zero) {
		Assert::That(memoryContents(0), Equals("00:00:00:00"));
	}

	Spec(ScreamingTest) {
		Assert::That(memoryContents(2863311530), Equals("AA:AA:AA:AA"));
	}

	Spec(Press_F_toPayRespectTest) {
		Assert::That(memoryContents(251658240), Equals("00:00:00:0F"));
	}
};

int main() {
	// Run all the tests defined above
	return TestRunner::RunAllTests();
}
