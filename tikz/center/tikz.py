#!/usr/bin/env python
# -*- coding: utf-8 -*-

from random import uniform
import random

n = 5
x_min, y_min = 0, 0
x_max, y_max = 5, 5
x_sum = 0
y_sum = 0
coordinates = []

random.seed(42)

for i in range(n):
    x = uniform(x_min, x_max)
    y = uniform(y_min, y_max)
    x_sum += x
    y_sum += y
    coordinates.append((x, y))

center = (float(x_sum) / n, float(y_sum) / n)

cx, cy = center
point_coords = ""
for p in coordinates:
    px, py = p
    new_p = "(%.2f,%.2f)," % (px, py)
    point_coords = new_p + point_coords
    delta_y = cy-py
    delta_x = cx-px
    length = (delta_y**2+delta_x**2)**0.5
    sin_alpha = delta_y/length
    cos_alpha = delta_x/length
    print("\draw[->] (%.2f,%.2f) -- (%.2f,%.2f);" %
          (px, py, px + cos_alpha*length*0.80, py + sin_alpha*length*0.80))

print("\\node[circle,inner sep=1pt,fill]  at (%.2f,%.2f) {};" % (cx, cy))

print("\\foreach \point in {" + point_coords + "}{")
print("\\node[dot] at \point {};")
print("}")
