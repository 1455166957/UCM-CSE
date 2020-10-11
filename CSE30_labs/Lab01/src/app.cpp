#include <iostream>
#include <Functions.h>

using namespace std;

int main(){

    if(even(0)){
        cout << "0 is an even number" <<endl;
    }

    cout << "The sum of numbers till 100 is " << sum(100) << endl;

    return 0;
}
