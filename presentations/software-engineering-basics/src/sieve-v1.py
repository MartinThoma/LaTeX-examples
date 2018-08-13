from math import ceil

def f(n=1000000):
    roundUp = lambda n, prime: int(ceil(float(n) / prime))

    arr = [True] * n
    arr[0] = False
    arr[1] = False
    primeList = []

    for curr in range(2, n):
        if not arr[curr]:
            continue
        primeList.append(curr)
        for multiplicant in range(2, roundUp(n, curr)):
            arr[multiplicant * curr] = False
    return primeList
