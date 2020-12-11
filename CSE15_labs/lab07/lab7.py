def compute_f(n):
    if n == 0:
        return 2
    elif n >= 1:
        return (compute_f(n-1)+2)

print(compute_f(0))
print(compute_f(1))
print(compute_f(2))
print(compute_f(3))


def count_instances(L,n):

    def tail(L):
        return L[1:]
    
    if not L:
        return 0
    elif L[0] == n:
        return (1 + count_instances(tail(L),n))
    else:
        return count_instances(tail(L),n)

L = [4,5,9,7,7,1,9,7,2]
print(count_instances(L,7))
