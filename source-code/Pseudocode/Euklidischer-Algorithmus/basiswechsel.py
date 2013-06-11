#!/usr/bin/env python
# -*- coding: utf-8 -*-

def euklid(b, Z):
    p = 0
    while b**p <= Z:
        p = p+1
    i = p - 1

    y = {}
    while Z != 0 and i > -5:
        y[i] = Z  // b**i
        R = Z % b**i
        Z = R
        i = i -1
    return y

if __name__ == "__main__":
    r = euklid(16, 15741.233)
    print("Result:")
    for key in sorted(r.iterkeys(),reverse=True):
        print "%s: %s" % (key, r[key])
