#!/usr/bin/python
# -*- coding: utf-8 -*-

from math import factorial
from gmpy import bincoef


def prob(people):
    return 1.0 - float(factorial(people)*bincoef(365, people))/(365**people)

if __name__ == '__main__':
    with open('data.csv', 'w') as f:
        f.write('People\tprobability\n')

        for people in xrange(60+1):
            f.write("%i\t%f\n" % (people, prob(people)))
