#!/usr/bin/env python

import numpy

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def euclideanDist(p1, p2):
    from math import sqrt
    return sqrt((p1.x-p2.x)**2 + (p1.y-p2.y)**2)

def getMinDist(y, precision=0.001, startX=0, endX=3):
    """Get x of point on (x,x^2) that has minimal distance to given Point."""
    minDist = -1
    p1 = Point(0, y)
    for x in numpy.arange(startX, endX, precision):
        p2 = Point(x, x**2)
        dist = euclideanDist(p1, p2)
        if minDist == -1 or dist < minDist:
            minDist = dist
            #print(dist)
        else:
            if abs(i-minDist) <0.005:
                print("x: %s" % str(x))
            break
    return minDist

for i in numpy.arange(0, 3, 0.01):
    minDist = getMinDist(i)
    if abs(i-minDist) < 0.005:
        print(i, minDist)

#print(getMinDist(5, 0.00001, 2, 3))
