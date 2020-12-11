def linear_search(s,k):
    i = 0
    while (i < len(s) and k != s[i]):
        i = i + 1
    if i < len(s):
        return i
    else:
        return -1

def binary_search(s,k):
    i = 0
    j = len(s)

    while (i < j):
        m = (i+j) // 2
        if (k > s[m]):
            i = m + 1
        else:
            j = m
    if k == s[i]:
        return i
    else:
        return -1


import random
import time

def gen_random_list(n):
    assert(n>0)
    l = [random.randint(0, 10*n) for i in range(n)]
    return l

l = gen_random_list(100000000)

start = time.perf_counter_ns()
linear_search(l, -42)
spent = time.perf_counter_ns() - start
print("It took " + str(spent) + " nanoseconds to perform linear search.")

l.sort()
start = time.perf_counter_ns()
binary_search(l, -42)
spent = time.perf_counter_ns() - start
print("It took " + str(spent) + " nanoseconds to perfrom binary search")
