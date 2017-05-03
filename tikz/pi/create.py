#!/usr/bin/env python

"""Create a data.csv file."""

import csv

try:
    # import version included with old SymPy
    from sympy.mpmath import mp
except ImportError:
    # import newer version
    from mpmath import mp

mp.dps = 1000  # set number of digits
pi = mp.pi
print(pi)

# Split pi in groups of two digits
pi = str(pi)[2:]
split_pi = []
for i in range(0, len(pi), 2):
    part = pi[i:i + 2]
    if len(part) != 2:
        continue
    split_pi.append(part)

# Representation of pi
data = [("x", "y", "color")]  # header
for e1, e2 in zip(split_pi, split_pi[1:]):
    tuple_date = (int(e1), int(e2), "c{}".format(int(int(e1) / 10)))
    data.append(tuple_date)

# Write data to csv
with open('data.csv', 'w') as fp:
    writer = csv.writer(fp, delimiter=',')
    writer.writerows(data)
