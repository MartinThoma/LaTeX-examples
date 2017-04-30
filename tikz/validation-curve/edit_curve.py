#!/usr/bin/env python

import csv
import glob
import numpy as np

history_files = glob.glob("cifar100_*.csv")
print(history_files)
data = []
loss = []

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
            loss.append([float(el[1])])
    else:
        for i, el in enumerate(datathis):
            if i == 0:
                continue
            if i == len(data):
                break
            data[i - 1].append(float(el[2]))
            loss[i - 1].append(float(el[1]))

# crop to where all are trained
print(len(data))
orderings = []
for i, el in enumerate(data):
    if len(el) != len(history_files):
        break
data = data[:i]
loss = loss[:i]
print(len(data))


# orderings
def get_changes(ord1, ord2):
    """Count how often the order changes between two elements."""
    changes = 0
    for i in range(10):
        for j in range(i + 1, 10):
            o1go2 = (ord1.index(i) > ord1.index(j) and
                     ord2.index(i) > ord2.index(j))
            o1lo2 = (ord1.index(i) < ord1.index(j) and
                     ord2.index(i) < ord2.index(j))
            if not (o1go2 or o1lo2):
                changes += 1

    return changes

if len(history_files) > 1:
    orderings = []
    for row in data:
        ordering = zip(range(10), row)
        ordering = sorted(ordering, key=lambda n: n[1])
        ordering = [el[0] for el in ordering]
        orderings.append(ordering)
    get_changes(orderings[0], orderings[1])

    change_list = []
    for ord1, ord2 in zip(orderings, orderings[1:]):
        changes = get_changes(ord1, ord2)
        change_list.append(changes)
    change_list = np.array(change_list)

    print("change_list = {}".format(change_list.mean()))

# write
max_range = 0
with open('baseline_cifar_test_acc.csv', 'w') as fp:
    writer = csv.writer(fp, delimiter=',')
    writer.writerow(["epoch", "min_acc", "max_acc", "mean_acc", "mean_loss"])
    for epoch, row in enumerate(data):
        if len(row) < len(history_files):
            break
        max_range = max(max_range, max(row) - min(row))
        writer.writerow([epoch, min(row), max(row), np.array(row).mean(),
                         np.array(loss[epoch]).mean()])
print("max_range={}".format(max_range))
