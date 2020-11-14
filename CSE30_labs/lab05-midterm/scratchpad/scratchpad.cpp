#include <iostream>
#include <RandomSupport.h>
#include <Array.h>
#include <LinkedList.h>
#include <TimeSupport.h>

using namespace std;

int main(int argc, char* argv[]){
	long size = 99999999;
	randomizer device = new_randomizer();
	uniform_distribution dist = new_distribution(1, size);

	long r = sample(dist, device);

	cout << endl << "The random number is: " << r << endl << endl;

	LinkedList linkedList;
	ResizableArray array;

	for (long i = 0; i < size; i++){
		linkedList.append(i);
		//array.append(i);
	}

	// cout << "Linked List: " << linkedList << endl;
	// cout << "Array:       " << array << endl;

	timestamp start = current_time();
    cout << "accessing the list." << endl;
    linkedList.get(r);
    timestamp end = current_time();
    long duration =time_diff(start, end);

	cout << "It took " << duration << " ms." << endl;

	return 0;
}
