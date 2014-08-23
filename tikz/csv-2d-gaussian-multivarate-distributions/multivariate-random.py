#!/usr/bin/env python

import matplotlib.pyplot as plt
import numpy
import csv

cov = [[25, 20], [20, 25]]  # diagonal covariance, points lie on x or y-axis

meanI = [70, 40]
datapointsI = 2000

meanII = [60, 20]
datapointsII = 2000

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
