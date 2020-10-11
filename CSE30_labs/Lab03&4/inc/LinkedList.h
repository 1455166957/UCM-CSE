#pragma once

#include <iostream>
#include <ostream>

using namespace std;

struct Node{
	int data;
	Node* next;

	Node (){
		data = 0;
		next = NULL;
	}

	Node (int n){
		data = n;
		next = NULL;
	}
};

struct LinkedList{

	Node* head;

	LinkedList(){
		head = NULL;
	}

	LinkedList(const LinkedList& other){
		head = NULL;

		if (other.head != NULL){
			Node* temp = other.head;
			while (temp != NULL){
				append(temp->data);
				temp = temp->next;
			}
		}
	}

	void append (int n){
		if (head == NULL){
			head = new Node(n);
		}
		else{
			Node* temp = head;
			while (temp->next != NULL){
				temp = temp->next;
			}
			// temp is pointing to the last element of the list
			Node* theNode = new Node(n);
			temp->next = theNode;
		}
	}

    int get(int index) {
        //my code
        Node* temp = head;
        int count = 0;

        while(temp != NULL) {
            if (count == index) {
                return temp->data;
            }
            count++;
            temp = temp->next;
        }
        cout << "Non-existent index was requested, returning 0." << endl;
        return 0;
    }

    void set(int index, int value) {
        //my code
        Node* temp = head;
        int count = 0;

        while(temp != NULL) {
            if (count == index) {
                temp->data = value;
                break;
            }
            count++;
            temp = temp->next;
        }
        if (temp == NULL) {
            cout << "Non-existent index was provided, nothing was set." << endl;
        }
    }

    void insert(int index, int value) {
        //my code
		Node* newNode = new Node(value);
		Node* temp = head;
		if(index == 0) { //inserting into head
			Node* oldHead = head;
			head = newNode;
			head->next = oldHead;
		} else {
			for (int i = 1; i < index; i++) {
				if(temp->next != NULL) {
					temp = temp->next;
				} else { //filling with 0's
					temp->next = new Node();
					temp = temp->next;
				}
			}
			Node* reserve = temp->next;
			temp->next = newNode;
			temp->next->next = reserve;
		}
    }

    void print() {
        Node* temp = head;
        while(temp != NULL) {
            cout << temp->data <<endl;
            temp = temp->next;
        }
    }

	bool operator==(const LinkedList& other) const {
		Node* ours = head;
		Node* theirs = other.head;

		while (ours != NULL){
			if (theirs == NULL){
				return false;
			}
			if (ours->data != theirs->data){
				return false;
			}
			else{
				ours = ours->next;
				theirs = theirs->next;
			}
		}
		return theirs == NULL;
	}

	~LinkedList(){
		Node* temp = head;
		while (temp != NULL){
			head = head->next;
			delete temp;
			temp = head;
		}
	}

};

std::ostream& operator<< (std::ostream& os, const LinkedList& theList){
	Node* temp = theList.head;
	while (temp != NULL){
		os << temp->data << " ";
		temp = temp->next;
	}
	return os;
}
