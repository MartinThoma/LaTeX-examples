#!/usr/bin/python
# -*- coding: utf-8 -*-

""" Dieses Script analysiert die Verteilung der Längen der Routen. Diese müssen
    durch "Entfernungen.txt" gegeben sein. 

    """

print("Beginne alle Routen zu lesen.")
f = open('/home/moose/mathe/Entfernungen.txt', 'r')
lines = f.readlines()
f.close()
print("Alle Routen wurden eingelesen.")

number = length = 0
minimum= int(lines[0])
maximum= int(lines[0])
liste = []
dict_entfernungen = {}
for line in lines:
    line = int(line)
    if line in dict_entfernungen:
        dict_entfernungen[line] += 1
    else:
        dict_entfernungen[line] = 1
    liste.append(line)
    number += 1
    length += line
    if line < minimum:
        minimum = line
    if line > maximum:
        maximum = line
print("Minimum: %i" % minimum)
print("Maximum: %i" % maximum)
print("Durchschnitt: %i" % (length/number))
print("Anzahl der Routen: %i" % number)

less_than2069 = 0.0
for length, count in dict_entfernungen.items():
    if length <= 2068:
        less_than2069 += count

print("maximale Abweichung von 5%%: %f %% aller Strecken" % (less_than2069/number*100))

EntfernungsSet = set(liste)
print("Anzahl der verschiedenen Streckenlängen: %i" % len(dict_entfernungen))

import math, pylab

x_list = []
y_list = []
for x, y in dict_entfernungen.items():
    y_list.append(y)
    x_list.append(x)

pylab.xlabel("Streckenlange in km")
pylab.ylabel("Anzahl der Routen")
pylab.plot(x_list, y_list, 'b')

# Einzeichnen des Durchschnitts:
y_max = max(y_list)
x_list = []
y_list = []
y_list.append(0)
x_list.append((length/number))
y_list.append(y_max)
x_list.append((length/number))
pylab.plot(x_list, y_list, 'r')

pylab.savefig('Fig1.png')

pylab.show()
