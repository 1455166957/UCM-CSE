#ifndef Arrays_h
#define Arrays_h

#include <iostream>
#include <ostream>

struct ResizableArray {
    // This is the poiner to the start of our array
    int* data;

    // Keep track of how much memory we have allocated
    int size;

    // Keep track of how much memory we have used
    int counter;

    // A default constructor
    ResizableArray() {
        // Start off by allocating memory for 1 int
        data = new int[1];

        // This means we have allocated for 1
        size = 1;

        // And we are currently using 0
        counter = 0;
    }

	// This is a copy constructor. It specifies what happens when
	// the array needs to be copied. In this case it performs
	// a deep copy, which is what we need
	ResizableArray(const ResizableArray& other){
		size = other.size;
		counter = other.counter;
		data = new int[other.size];

		for (int i = 0; i < other.size; i++){
			data[i] = other.data[i];
		}
	}

	// Overloading the == operator. Now we can compare
	// two ResizableArrays with the == operator
	bool operator==(const ResizableArray rhs) const {
		// If the sizes or counters are different, it's not a match
		if (size != rhs.size){
			return false;
		}
		if (counter != rhs.counter){
			return false;
		}

		// Assume the arrays match
		bool same = true;

		// And try to find a contradiction
		for (int i = 0; i < counter; i++){
			if (data[i] != rhs.data[i]){
				return false;
			}
		}

		// Colud not get a contradiction
		return true;
	}

    // Print the contents we have
    void print(){
        for (int i = 0; i < counter; i++){
            std::cout << data[i] << std::endl;
        }
    }

	// Get the value at a specified position
    int get(int index){
        // Your code here...
        return data[index];
    }

	// Set the value at a specified position with a given integer
    void set(int index, int value){
        // Your code here...
        data[index] = value;
    }

    void expand(){
            int oldSize = size;
            size = size * 2;
            int* newArr = new int[size];
            for (int i = 0; i < oldSize; i++) {
                newArr[i] = data[i];
            }
            delete[] data;
            data = newArr;
    }

	void insert(int index, int value){
        // Your code here...

        if (index == (counter)) {  //Simplest case, where we insert the value into the current unoccupied position
            counter++;
            if(counter == size) {
                expand();
            }
            data[index] = value;
        }

        else if (index < (counter)) {   //Case, where we insert the value into already occupied position
            counter++;
            if(counter == size) {
                expand();
            }
            for(int i = counter; i > index; i--) {  //Shift everything preceding to the right by one
                data[i] = data[i - 1];
            }
            data[index] = value;
        }

        else if (index > (counter)) {  //Case, where the index is further than counter and may be further than the size
            while(index >= (size-1)) {  //expand if not enough space in the current size of the array
                expand();
            }
            for(int i = counter; i < index; i++) { //Set every unoccupied value before index to zero
                data[i] = 0;
            }
            data[index] = value;
            counter = index + 1; //update counter
        }
    }


    // Store a new value in the array
    void append(int value){
        // The very first time this is called
        // we know we have enough storage allocated
        // because we allocated space for 1 int
        // so we store it
        data[counter] = value;
        // and increase the counter
        counter++;

        // If we are out of space, i.e. we have
        // stored as much as we have allocated
        // then we need to increase our storage space
        if (counter == size){
            // Just for convenience, store the old size
            int oldSize = size;

            // Let's double the amount of storage we have
            size = size * 2;

            // Allocate another chunk of memory
            // twice as big as the first
            int* newArr = new int[size];

            // Copy all elements from the old location
            // to the new location
            for (int i = 0; i < oldSize; i++) {
                newArr[i] = data[i];
            }

            // Release the old location
            delete[] data;

            // Make our data pointer point to the new location
            data = newArr;

        }
    }

	// This is called a destructor. It simply releases the
	// memory we have been using.
	~ResizableArray(){
		delete[] data;
	}
};

// This is an overload of the << operator, which allows us
// to print out the ResizableArray with cout <<
std::ostream& operator<<(std::ostream& os, const ResizableArray& arr) {
    for (int i = 0; i < arr.counter; i++){
		os << arr.data[i] << " ";
	}
	os << " - counter: " << arr.counter << ", size: " << arr.size << std::endl;

    return os;
}

#endif
