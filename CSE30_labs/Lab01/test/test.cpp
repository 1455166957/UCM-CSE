#include <igloo/igloo.h>
#include <Functions.h>
using namespace igloo;

Context(MaxFunctionTests){
    Spec(OneGreaterThanZero){
        Assert::That(max(1,0), Equals(1));
    }
    Spec(ZeroLessThanOne){
        Assert::That(max(0,1), Equals(1));
    }
    Spec(TwentyGreaterThanEleven){
        Assert::That(max(20,11), Equals(20));
    }
    Spec(NegativeTwoLessThanOne){
        Assert::That(max(-2,1), Equals(1));
    }
};

Context(EvenFunctionTests){
    Spec(TryTwo){
        Assert::That(even(2), Equals(true));
    }
    Spec(TryThree){
        Assert::That(even(3), Equals(false));
    }
    Spec(TryZero){
        Assert::That(even(0), Equals(true));
    }
    Spec(TryNegativeFive){
        Assert::That(even(-5), Equals(false));
    }
    Spec(TryNegativeEight){
        Assert::That(even(-8), Equals(true));
    }
    Spec(TryThousand){
        Assert::That(even(1000), Equals(true));
    }
    Spec(TryThousandAndOne){
        Assert::That(even(1001), Equals(false));
    }
};

Context(SumFunctionTests){
    Spec(SumOne){
        Assert::That(sum(1), Equals(1));
    }
    Spec(SumThree){
        Assert::That(sum(3), Equals(6));
    }
    Spec(SumFive){
        Assert::That(sum(5), Equals(15));
    }
};


int main() {
	// Run all the tests defined above
	return TestRunner::RunAllTests();
}
