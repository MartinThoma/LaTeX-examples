#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Create samples for bivariate distribution"""

from numpy.random import multivariate_normal, seed


def create_data(n):
    means = [0.0, 0.0]
    cov = [[1.0, 0.7], [0.7, 4.0]]
    seed(0)
    samples = multivariate_normal(means, cov, n)
    with open("data.csv", "w") as f:
        f.write("x,y\n")
        for datapoint in samples:
            f.write("%0.4f,%0.4f\n" % tuple(datapoint))


def get_parser():
    from argparse import ArgumentParser, ArgumentDefaultsHelpFormatter
    parser = ArgumentParser(description=__doc__,
                            formatter_class=ArgumentDefaultsHelpFormatter)
    parser.add_argument("-n",
                        dest="n",
                        default=5000,
                        type=int,
                        help="Number of points to generate")
    return parser


if __name__ == "__main__":
    args = get_parser().parse_args()
    create_data(args.n)
