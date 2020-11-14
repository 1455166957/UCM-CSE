#include <iostream>
#include <ostream>
#include <Array.h>

using namespace std;

/*
The function starts comparing the values from the end and swaps them until it
hits the condition element < previous element or reaches the beginning.
The order of complexity is O(n) because it iterates the amount of times limited
by the size of the array.

Best case scenario is when we are inserting the largest value, then it would
take just one comparison and insert it at the end. O(1).

Worst case is when we are inserting the least value, then it would take
n comparisons and swaps, where n is the length of the array. O(n).
*/

struct SortedArray : ResizableArray {
    void insert(long value) {
        append(value);
        for (long i = count-1; (data[i] < data[i-1]) && (i > 0); i--) {
            long temp = data[i];
            data[i] = data[i-1];
            data[i-1] = temp;
        }
    }
};

/*
P.S.
After copypasting some code from other structs, I realized that this function
is perfect for inheritance from Array.h. This makes the solution nice and efficient
with overloading just one function.
Although this struct therefore has append and set functions, the unit tests
are done hard coding.
*/
