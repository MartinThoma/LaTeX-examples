#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
import shutil
import fileinput
import math


def main(filename, bins, maximum, yticks_number):
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
    xticklabels = []
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
    minimum = 0
    for b in range(bins):
        lower = minimum + (maximum - minimum)/bins*b
        xticklabels.append(get_xticklabel(lower))

    # Get labels for y-axis
    yticks = []
    ytickslabels = []
    maxy = max(bin_counter)
    maxylabel = int(10**math.floor(math.log(maxy, 10)))*int(str(maxy)[0])
    ylabelsteps = int(math.ceil(maxylabel / yticks_number))
    if ylabelsteps == 0:
        ylabelsteps = 1
    for i in range(0, maxylabel+1, ylabelsteps):
        print("i: %i, %i" % (i, maxylabel))
        print("label: %i%s" % get_si_suffix(i))
        yticks.append(str(i))
        ytickslabels.append(get_yticklabel(i, True))

    xticklabels.append("\infty")
    return bin_counter, xticklabels, ytickslabels, yticks


def get_xticklabel(value):
    return str(int(value))


def get_yticklabel(value, si_suffix):
    value = float(value)
    if si_suffix:
        divide_by, suffix = get_si_suffix(value)
        new_value = (value / divide_by)
        if int(new_value) == new_value:
            return ("%i" % int(new_value)) + suffix
        else:
            return ("%0.2f" % new_value) + suffix
    else:
        return str(value)


def get_si_suffix(value):
    if value >= 10**3:
        return (10**3, "K")
    elif value >= 10**6:
        return (10**6, "M")
    else:
        return (1, "")


def modify_template(bin_counter, xticklabels, yticklabels, yticks):
    shutil.copyfile("histogram-large-1d-dataset.template.tex",
                    "histogram-large-1d-dataset.tex")
    xticklabels = ", ".join(map(lambda n: "$%s$" % n, xticklabels))
    yticklabels = ", ".join(yticklabels)
    yticks = ",".join(yticks)
    coordinates = ""
    for i, value in enumerate(bin_counter):
        coordinates += "(%i, %i) " % (i, value)
    for line in fileinput.input("histogram-large-1d-dataset.tex",
                                inplace=True):
        line = line.replace("{{xticklabels}}", xticklabels)
        line = line.replace("{{yticklabels}}", yticklabels)
        line = line.replace("{{yticks}}", yticks)
        line = line.replace("{{coordinates}}", coordinates)
        print(line, end='')


if __name__ == '__main__':
    from argparse import ArgumentParser, ArgumentDefaultsHelpFormatter
    parser = ArgumentParser(description=__doc__,
                            formatter_class=ArgumentDefaultsHelpFormatter)
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
    parser.add_argument("--yticks", dest="yticks", type=int,
                        default=5,
                        help=("How many y-ticks should be used?"))
    args = parser.parse_args()
    bin_counter, xticklabels, yticklabels, yticks = main(args.filename,
                                                         args.bins,
                                                         args.max,
                                                         args.yticks)
    modify_template(bin_counter, xticklabels, yticklabels, yticks)
