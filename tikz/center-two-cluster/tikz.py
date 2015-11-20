from random import uniform
import random
import math

print """\documentclass{article}
\usepackage[pdftex,active,tightpage]{preview}
\setlength\PreviewBorder{2mm}
\usepackage{tikz}
\usepackage{tkz-fct}
\usetikzlibrary{shapes.misc}
\usetikzlibrary{shapes, calc, decorations}
\usepackage{amsmath,amssymb}

\\begin{document}
\\begin{preview}
\\begin{tikzpicture}[scale=0.1,dot/.style={    thick,
    draw=gray,
    cross out,
    inner sep=0pt,
    minimum width=4pt,
    minimum height=4pt}]
"""


def get_position_from_offset(px, py, angle, radius):
    x = px + radius * math.cos(math.radians(angle))
    y = py + radius * math.sin(math.radians(angle))
    return (x, y)

n = 5
xSum = 0
ySum = 0
coordinates = [(0, 0)]

random.seed(13)

for i in range(n-1):
    radius = uniform(0, 20)
    angle = uniform(0, 360)
    px, py = coordinates[-1]
    x, y = get_position_from_offset(px, py, angle, radius)
    xSum += x
    ySum += y
    coordinates.append((x, y))

center = (float(xSum) / n, float(ySum) / n)

cx, cy = center
coordinates.append((cx+15, cy))

pointCoords = ""
for p in coordinates:
    px, py = p
    px -= cx
    py -= cy
    newP = "(%.2f,%.2f)," % (px, py)
    pointCoords = newP + pointCoords
    deltaY = 0-py
    deltaX = 0-px
    length = (deltaY**2+deltaX**2)**0.5
    sinAlpha = deltaY/length
    cosAlpha = deltaX/length
    print("\draw[->] (%.2f,%.2f) -- (%.2f,%.2f);" %
          (px, py, px+cosAlpha*length*0.80, py+sinAlpha*length*0.80))

print("\\node[circle,inner sep=1pt,fill]  at (%.2f,%.2f) {};" % (0, 0))

print("\\foreach \point in {" + pointCoords[:-1] + "}{")
print("\\node[dot] at \point {};")
print("}")

###############################################################################
random.seed(17)
xSum = 0
ySum = 0
coordinates = [(0, 0)]
for i in range(n-1):
    radius = uniform(0, 20)
    angle = uniform(0, 360)
    px, py = coordinates[-1]
    x, y = get_position_from_offset(px, py, angle, radius)
    xSum += x
    ySum += y
    coordinates.append((x, y))

center = (float(xSum) / n, float(ySum) / n)

cx, cy = center
coordinates.append((cx-15, cy))
xOffset = 40
cTmp = []
for p in coordinates:
    px, py = p
    cTmp.append((px-cx+xOffset, py-cy))

coordinates = cTmp
cx, cy = xOffset, 0
pointCoords = ""

for p in coordinates:
    px, py = p
    newP = "(%.2f,%.2f)," % (px, py)
    pointCoords = newP + pointCoords
    deltaY = -py
    deltaX = xOffset-px
    length = (deltaY**2+deltaX**2)**0.5
    sinAlpha = deltaY/length
    cosAlpha = deltaX/length
    print("\draw[->] (%.2f,%.2f) -- (%.2f,%.2f);" %
          (px, py, px+cosAlpha*length*0.80, py+sinAlpha*length*0.80))


print("\\node[circle,inner sep=1pt,fill]  at (%.2f,%.2f) {};" % (xOffset, 0))

print("\\foreach \point in {" + pointCoords[:-1] + "}{")
print("\\node[dot] at \point {};")
print("}")

##################################

print("\\node[circle,inner sep=1pt,fill]  at (%.2f,%.2f) {};" % (xOffset, 0))

print("\\foreach \point in {(15,0), (35,0)}{")
print("\\node[dot] at \point {};")
print("}")


print """
\end{tikzpicture}
\end{preview}
\end{document}
"""
