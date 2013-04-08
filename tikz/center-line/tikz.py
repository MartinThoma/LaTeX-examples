from random import uniform
import random
import math

n = 5
xMin, yMin = 0, 0
xMax, yMax = 5, 5
xSum = 0
ySum = 0
coordinates = []

random.seed(42)

for i in range(n):
	x = uniform(xMin, xMax)
	y = uniform(yMin, yMax)
	xSum += x
	ySum += y
	coordinates.append((x,y))

center = (float(xSum) / n, float(ySum) / n)

cx, cy = center
pointCoords = ""
for p in coordinates:
	px, py = p	
	newP = "(%.2f,%.2f)," % (px, py)
	pointCoords = newP + pointCoords
	deltaY = cy-py
	deltaX = cx-px
	length = (deltaY**2+deltaX**2)**0.5
	sinAlpha = deltaY/length
	cosAlpha = deltaX/length
	print("\draw[->] (%.2f,%.2f) -- (%.2f,%.2f);" % (px, py, px+cosAlpha*length*0.80, py+sinAlpha*length*0.80))

print("\\node[circle,inner sep=1pt,fill]  at (%.2f,%.2f) {};" % (cx, cy))

print("\\foreach \point in {" + pointCoords + "}{")
print("\\node[dot] at \point {};")
print("}")
