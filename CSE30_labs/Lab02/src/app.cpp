#include <iostream>
#include <MemoryStuff.h>

using namespace std;

int main(){
    // Your code here
    int x;
    cout << "Enter the number of your interest: ";
    cin >> x;
    cout << "Memory representaion is " << memoryContents(x) << endl;

    return 0;
}
