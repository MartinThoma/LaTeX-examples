#!/usr/bin/env python

import matplotlib.pyplot as plt
import numpy
import csv


def main(n):
    cov = [[25, 20], [20, 25]]

    meanI = [70, 40]
    datapointsI = n

    meanII = [60, 20]
    datapointsII = n

    dataI = numpy.random.multivariate_normal(meanI, cov, datapointsI).T
    x, y = dataI
    plt.plot(x, y, 'x')

    dataII = numpy.random.multivariate_normal(meanII, cov, datapointsII).T
    x, y = dataII
    plt.plot(x, y, 'x')

    plt.axis('equal')
    plt.show()

    data = []
    xs, ys = dataI
    for x, y in zip(xs, ys):
        data.append([x, y, 'a'])
    xs, ys = dataII
    for x, y in zip(xs, ys):
        data.append([x, y, 'b'])

    # Write data to csv files
    with open("data.csv", 'wb') as csvfile:
        csvfile.write("x,y,label\n")
        spamwriter = csv.writer(csvfile, delimiter=',',
                                quotechar='"', quoting=csv.QUOTE_MINIMAL)
        for datapoint in data:
            spamwriter.writerow(datapoint)

if __name__ == "__main__":
    from argparse import ArgumentParser, ArgumentDefaultsHelpFormatter
    parser = ArgumentParser(description=__doc__,
                            formatter_class=ArgumentDefaultsHelpFormatter)
    parser.add_argument("-n",
                        dest="n", default=2000, type=int,
                        help="how many points should get generated")
    args = parser.parse_args()
    main(args.n)
