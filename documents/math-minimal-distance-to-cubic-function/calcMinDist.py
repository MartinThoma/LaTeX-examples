#!/usr/bin/env python

import numpy


class Point:
    """Represents a point in 2D."""
    def __init__(self, x, y):
        self.x = x
        self.y = y


def euclidean_dist(p1, p2):
    """Euclidean distance of two 2D points."""
    from math import sqrt
    return sqrt((p1.x-p2.x)**2 + (p1.y-p2.y)**2)


def get_min_dist(p1, precision=0.001, start_x=0, end_x=3):
    """Get x of point on (x,x^2) that has minimal distance to given Point p."""
    min_dist = -1
    for x in numpy.arange(start_x, end_x, precision):
        p2 = Point(x, x**2)
        dist = euclidean_dist(p1, p2)
        if min_dist == -1 or dist < min_dist:
            min_dist = dist
    return min_dist

"""for i in numpy.arange(0, 3, 0.01):
    min_dist = get_min_dist(Point(0, i))
    if abs(i-min_dist) < 0.005:
        print(i, min_dist)"""

print(get_min_dist(Point(0, 4.25), precision=0.001, start_x=0, end_x=3))
# print(euclidean_dist(Point(0,5),Point(2, 2**2)))

# print(get_min_dist(5, 0.00001, 2, 3))
