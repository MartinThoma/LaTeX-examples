#!/usr/bin/python
# -*- coding: utf-8 -*-


def print_arr(a):
    for line in a:
        print(line)


def initialise(n):
    array = [[0 for j in xrange(0, n)] for i in xrange(0, n)]
    return array


def spiral_fill(a):
    n = len(a)
    x = y = n/2
    number = 1
    #         r       u       l        o
    order = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    i_order = 0
    length = 1
    a[y][x] = number
    while not (x == (n-1) and y == 0):
        for j in xrange(0, length):
            xAdd, yAdd = order[i_order]
            x += xAdd
            y += yAdd
            number += 1
            a[y][x] = number
            if x == (n-1) and y == 0:
                break
        if i_order == 1 or i_order == 3:
            length += 1
        i_order = (i_order+1) % 4
    return a


def diagonal_sum(a):
    n = len(a)
    sum = -1  # you will have the element in the middle (1) twice
    for i in xrange(0, n):
        sum += a[i][i]
        sum += a[n-i-1][i]
    return sum

if __name__ == "__main__":
    import argparse

    parser = argparse.ArgumentParser(description="ProjectEuler: 28")
    parser.add_argument("-n", metavar='N', type=int,
                        help="length of the spiral", required=True)
    parser.add_argument("-d", action="store_true", default=False,
                        help="display the spiral")
    args = parser.parse_args()
    array = initialise(args.n)
    array = spiral_fill(array)
    if args.d:
        print_arr(array)
    print diagonal_sum(array)
