#ifndef Functions_h
#define Functions_h


int max(int x, int y) {
    if (x > y) {
        return x;
    } else {
        return y;
    }
}

bool even(int x) {
    if (x % 2 == 0) {
        return true;
    } else {
        return false;
    }
}

int sum(int x) {
    int sum = 0;
    for (int i = 1; i <= x; i++) {
        sum += i;
    }
    return sum;
}


#endif