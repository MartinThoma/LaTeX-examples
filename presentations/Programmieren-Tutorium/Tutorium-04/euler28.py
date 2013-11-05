#!/usr/bin/python
# -*- coding: utf-8 -*-

def printArr(a):
    for line in a:
        print(line)

def initialise(n):
    array = [[0  for j in xrange(0,n)] for i in xrange(0,n)]
    return array

def spiralFill(a):
    n = len(a)
    x = y = n/2
    number = 1
            # r      u       l      o
    order = [(1,0), (0,1), (-1,0), (0,-1)]
    iOrder = 0
    length = 1
    a[y][x] = number
    while not (x == (n-1) and y == 0):
        for j in xrange(0, length):
            xAdd, yAdd = order[iOrder]
            x += xAdd
            y += yAdd
            number += 1
            a[y][x] = number
            if x == (n-1) and y==0:
                break
        if iOrder == 1 or iOrder == 3:
            length += 1
        iOrder = (iOrder+1) % 4
    return a

def diagonalSum(a):
    n = len(a)
    sum = -1 # you will have the element in the middle (1) twice
    for i in xrange(0, n):
        sum += a[i][i]
        sum += a[n-i-1][i]
    return sum

if __name__ == "__main__":
    import argparse
 
    parser = argparse.ArgumentParser(description="ProjectEuler: 28")
    parser.add_argument("-n", metavar='N', type=int,
                        help="length of the spiral", required=True)
    parser.add_argument("-d", action="store_true",default=False,
                        help="display the spiral")
    args = parser.parse_args()
    array = initialise(args.n)
    array = spiralFill(array)
    if args.d:
        printArr(array)
    print diagonalSum(array)
