#include <iostream>
#include <MemoryStuff.h>

using namespace std;

int main(int argc, char* argv[]){

	// We first check if the user has provided the appropriate command line parameters
	// We need 3 because the name of the program itself is parameter 0
	// So if we are passing in two things, we need 3 parameters
	if (argc < 3){
		// If not, we display a message of what the program expects
		cout << "Usage: ./bin/scratch [operation] [value]\n\n[operation]: d2h - Decimal to Hex (requires a decimal [value])\n             h2d - Hex to Decimal (requires a hex [value])" << endl;

		// Exiting with 1 means that the program did not complete successfully.
		// This is not really important, unless the results of this program were used as
		// input to another program. In that case, the other program would care about
		// the exit code, so we inform it that something was not right.
		return 1;
	}
	else{
		// If we are here, it means we have the parameters we need
		// The 1st parameter is the operation we need to perform
		string op = string(argv[1]);

		// The operation can only be "d2h" or "h2d"
		if (op == "d2h"){
			// Converting decimal to hex
			try {
				// We use a try block because if the user entered a non-valid
				// integer value, our program will crash.
				// The try statement prevents it from crashing because of the catch
				// phrase below.
				// Basically we are saying: 
				// Try to convert whatever the user typed into an integer
				// If there is an error, catch it, don't let the program crash
				int arg = stoi(string(argv[2]));
				cout << decToHex(arg) << endl; // Calling our function from MemoryStuff.h
			} 
			catch (...) {
				// If we get here it means the user typed in an invalid integer value
				// So instead of crashing, we simply print a message to that effect
				// and we exit gracefully, with exic code 1.
				cout << "Invalid decimal value" << endl;
				return 1;
			}

		}
		else if (op == "h2d"){
			try{
				// Same thing here. If the user typed in a non-valid hex value
				// we don't let the program crash. We just inform the user of that.
				string arg = string(argv[2]);
				cout << stoi(arg, 0, 16) << endl;
			}
			catch (...){
				cout << "Invalid hex value" << endl;
				return 1;
			}
			
		}
		else{
			// Operation entered was not one of the two we support
			cout << "Invalid operation flag" << endl;
			return 1;
		}

		// If we get here, it means that there were no errors caught above, so we can exit with our usual code of 0
		return 0;
	}

}
