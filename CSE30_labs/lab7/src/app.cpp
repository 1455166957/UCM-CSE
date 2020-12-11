#include <iostream>
#include <fstream>
#include <algorithm>
#include <string>
#include <Array.h>
#include <LinkedList.h>
#include <TimeSupport.h>

using namespace std;

string reverse(string word) {
	reverse(word.begin(), word.end());
	return word;
}

long hash_function(string word) {
	while (word.length() < 4) {
		word += ' ';
	}
	return word[0]*128*128*128 + word[1]*128*128 + word[2]*128 + word[3];
}

bool find(string word, LinkedList table[]) {
	string rev = reverse(word);
	long hash = hash_function(rev);
	return table[hash].search(rev);
}



int main(int argc, char* argv[]){

	fstream file;

	string provided = "words.txt";

	const long N = 128*128*128*128;

	LinkedList* words = new LinkedList[N];

	file.open(provided, ios::in);
	if (file.is_open()) {
		string tp;
		while(getline(file, tp)) {
			words[hash_function(tp)].append(tp);
		}
		file.close();
	} else {
		cout << "Could not read file..." << endl;
	}

	timestamp start = current_time();
	int occurrences = 0;
	file.open(provided, ios::in);
	if (file.is_open()) {
		string tp;
		while(getline(file, tp)) {
			if(find(tp, words)) {
				occurrences++;
			}
		}
		file.close();
	} else {
		cout << "Could not read file 2..." << endl;
	}
	timestamp end = current_time();

	cout << "There were " << occurrences << " words that match..." << endl;
	cout << "It took " << time_diff(start, end) << " milliseconds." << endl;

	delete [] words;
	return 0;
}
