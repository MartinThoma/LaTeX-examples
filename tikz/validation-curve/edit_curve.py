#!/usr/bin/env python

import csv
import glob
import numpy as np

history_files = glob.glob("*.csv")
data = []

for filename in history_files:
    print(filename)
    with open(filename) as f:
        reader = csv.reader(f)
        datathis = [row for row in reader]

    if len(data) == 0:
        for i, el in enumerate(datathis):
            if i == 0:
                continue
            data.append([float(el[2])])
        print(data)
    else:
        for i, el in enumerate(datathis):
            if i == 0:
                continue
            if i == len(data):
                break
            data[i - 1].append(float(el[2]))

print("!" * 80)
print(data)
print("-" * 80)
max_range = 0
with open('baseline_cifar_test_acc.csv', 'w') as fp:
    writer = csv.writer(fp, delimiter=',')
    writer.writerow(["epoch", "min_acc", "max_acc", "mean_acc"])
    for epoch, row in enumerate(data):
        if len(row) < 10:
            print(row)
            print(len(row))
            break
        max_range = max(max_range, max(row) - min(row))
        print("max range={}, epoch={}".format(max_range, epoch))
        writer.writerow([epoch, min(row), max(row), np.array(row).mean()])
print(max_range)
