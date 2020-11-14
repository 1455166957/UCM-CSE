#include <iostream>
#include <Array.h>
#include <LinkedList.h>
#include <RandomSupport.h>
#include <TimeSupport.h>

using namespace std;

int main(){
    // Your code here...

    //The task says to perform an insersion, but doesn't specify where.
    //I would insert in some arbitrary position, but insert func for linked lists is not provided.
    //I could import my own one, but I don't know if that's allowed for this lab.
    //So I decided to perform insertion into position 0,
    //so that the shifting for arrays is still happenning,
    //and linked list insertions doesn't really have much operational difference regarding the position of insertion.

    long size = 100000;
    randomizer device = new_randomizer();
	uniform_distribution dist = new_distribution(1, 9999999);

    LinkedList linkedList;
	ResizableArray array;

    timestamp arrStart = current_time();
    for (int i = 0; i < size; i++) {
        long r = sample(dist, device);
        array.insert(0, r);
    }
    timestamp arrEnd = current_time();

    timestamp listStart = current_time();
    for (int i = 0; i < size; i++) {
        long r = sample(dist, device);
        linkedList.prepend(r);
    }
    timestamp listEnd = current_time();

    long arrDuration = time_diff(arrStart, arrEnd);
    long listDuration = time_diff(listStart, listEnd);

    cout << "Insertion into array took " << arrDuration << " ms." << endl;
    cout << "Insertion into list took " << listDuration << " ms." << endl;

    return 0;
}
