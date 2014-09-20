#!/usr/bin/env python

import csv


def eea(a, b):
    """
    Calculates u*a + v*b = ggT
    returns (ggT, u, v, steps)
    """
    u, v, s, t, steps = 1, 0, 0, 1, 0
    while b > 0:
        q = a//b
        a, b = b, a-q*b
        u, s = s, u-q*s
        v, t = t, v-q*t
        steps += 1
    return a, u, v, steps


def create_csv(n, filename):
    max_steps = 0
    with open(filename, 'wb') as csvfile:
        csvwriter = csv.writer(csvfile, delimiter=',',
                               quotechar='"', quoting=csv.QUOTE_MINIMAL)
        csvwriter.writerow(["x", "y", "steps"])
        for x in range(n):
            for y in range(n):
                steps = eea(x, y)[-1]
                max_steps = max(steps, max_steps)
                csvwriter.writerow([x, y, steps])
    print("Maximum step number: %i" % max_steps)

if __name__ == "__main__":
    from argparse import ArgumentParser, ArgumentDefaultsHelpFormatter
    parser = ArgumentParser(description=__doc__,
                            formatter_class=ArgumentDefaultsHelpFormatter)
    parser.add_argument("-n",
                        dest="n", default=10, type=int,
                        help="how many lines get printed")
    args = parser.parse_args()
    create_csv(args.n, "data.csv")
