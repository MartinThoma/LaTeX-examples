#!/usr/bin/python
# -*- coding: utf-8 -*-

from math import factorial
from gmpy import bincoef

f = open('data.csv', 'w')
f.write('People\tprobability\n')

def prob(people):
    return 1.0 - float(factorial(people)*bincoef(365,people))/(365**people)

for people in xrange(60+1):
    f.write("%i\t%f\n" % (people, prob(people)))
