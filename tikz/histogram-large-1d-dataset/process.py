#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
import shutil
import fileinput


def main(filename, bins, maximum):
    with open(filename) as f:
        content = f.read().split("\n")
    numbers = []
    for line in content:
        line = line.strip()
        if line != "":
            numbers.append(float(line))
    numbers = sorted(numbers)
    minimum = min(numbers)
    bin_counter = [0 for i in range(bins+1)]
    borders = []
    for i, number in enumerate(numbers):
        if number >= minimum + (maximum - minimum)/bins*(bins+1):
            bin_counter[bins] += 1
        elif number < minimum:
            bin_counter[0] += 1
        else:
            for b in range(bins):
                lower = minimum + (maximum - minimum)/bins*b
                upper = minimum + (maximum - minimum)/bins*(b+1)
                if lower <= number < upper:
                    bin_counter[b] += 1
                    break
    for b in range(bins):
        lower = minimum + (maximum - minimum)/bins*b
        borders.append(str(lower))
    borders.append("\infty")
    return bin_counter, borders


def modify_template(bin_counter, borders):
    shutil.copyfile("histogram-large-1d-dataset.template.tex",
                    "histogram-large-1d-dataset.tex")
    xticklabels = ", ".join(map(lambda n: "$%s$" % n, borders))
    coordinates = ""
    for i, value in enumerate(bin_counter):
        coordinates += "(%i, %i) " % (i, value)
    for line in fileinput.input("histogram-large-1d-dataset.tex",
                                inplace=True):
        line = line.replace("{{xticklabels}}", xticklabels)
        line = line.replace("{{coordinates}}", coordinates)
        print(line, end='')


if __name__ == '__main__':
    from argparse import ArgumentParser
    parser = ArgumentParser()
    parser.add_argument("-f", "--file", dest="filename",
                        default="1ddata.txt",
                        help="use FILE as input data", metavar="FILE")
    parser.add_argument("-b", "--bins", dest="bins", type=int,
                        default=15,
                        help="how many bins should be used")
    parser.add_argument("-m", "--max", dest="max", type=float,
                        default=15000,
                        help=("what is the maximum number "
                              "that should get binned?"))
    args = parser.parse_args()
    bin_counter, borders = main(args.filename, args.bins, args.max)
    modify_template(bin_counter, borders)
