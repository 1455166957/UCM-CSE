#include <iostream>
#include <Arrays.h>
#include <LinkedList.h>

using namespace std;

int main(){
    ResizableArray array;

    for (int i = 0; i < 6; i++) {
        array.append(i);
    }

    array.insert(2, 77);

    array.insert(10, 89);

    array.append(101);

    // Print out the array
    array.print();

    cout << "count: " << array.counter << endl;
    cout << "size : " << array.size << endl << endl;


    //Lab04
    LinkedList myList;

    for (int i = 0; i < 6; i++) {
        myList.append(i);
    }

    myList.insert(2, 77);
    myList.insert(10, 89);
    myList.append(101);
    myList.set(0, 11);
    cout << myList.get(2) << endl << endl;
    myList.print();

    return 0;
}
