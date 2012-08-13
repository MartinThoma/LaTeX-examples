#!/usr/bin/python
# -*- coding: utf-8 -*-

""" Dieses Script berechnet die Länge aller möglichen Routen und speichert sie
    in "Entfernungen.txt". 
    Am Ende wird noch die optimale Route ausgegeben. 

    Benötigte Rechenzeit: ca. 50s """

from copy import deepcopy

# http://blog.bjrn.se/2008/04/lexicographic-permutations-using.html
def next_permutation(seq, pred=cmp):
    """Like C++ std::next_permutation() but implemented as
    generator. Yields copies of seq."""
    def reverse(seq, start, end):
        # seq = seq[:start] + reversed(seq[start:end]) + \
        #       seq[end:]
        end -= 1
        if end <= start:
            return
        while True:
            seq[start], seq[end] = seq[end], seq[start]
            if start == end or start+1 == end:
                return
            start += 1
            end -= 1
    if not seq:
        raise StopIteration
    try:
        seq[0]
    except TypeError:
        raise TypeError("seq must allow random access.")
    first = 0
    last = len(seq)
    seq = seq[:]
    # Yield input sequence as the STL version is often
    # used inside do {} while.
    yield seq
    if last == 1:
        raise StopIteration
    while True:
        next = last - 1
        while True:
            # Step 1.
            next1 = next
            next -= 1
            if pred(seq[next], seq[next1]) < 0:
                # Step 2.
                mid = last - 1
                while not (pred(seq[next], seq[mid]) < 0):
                    mid -= 1
                seq[next], seq[mid] = seq[mid], seq[next]
                # Step 3.
                reverse(seq, next1, last)
                # Change to yield references to get rid of
                # (at worst) |seq|! copy operations.
                yield seq[:]
                break
            if next == first:
                raise StopIteration
    raise StopIteration

def Strecke_der_Route(Entfernungen, route):
    """ Bestimmt die länge der Route und gibt diese als int zurück """
    Entfernung = 0
    for step, index in enumerate(route):
        index2 = route[(step+1)%len(Entfernungen)]
        Entfernung += Entfernungen[index][index2] # von index nach index2
    return Entfernung

def optimal_solution_with_brute_force(Entfernungen):
    """ Findet die optimale Lösung, indem alle Routen durchgegangen werden.
        Zurückgegeben wird eine Liste mit den Indizes """
    liste = [i for i in xrange(0, len(Entfernungen))]
    min_Entfernung_Route = [i for i in xrange(0, len(Entfernungen))]
    min_Entfernung = Strecke_der_Route(Entfernungen, min_Entfernung_Route)
    f = open('/home/moose/Entfernungen.txt', 'w')
    for route in next_permutation(liste):
        entfernung_tmp = Strecke_der_Route(Entfernungen, route)
        f.write(str(entfernung_tmp) + "\n")
        if entfernung_tmp < min_Entfernung:
            min_Entfernung = entfernung_tmp
            min_Entfernung_Route = deepcopy(route)
    f.close()
    return min_Entfernung_Route

Stadtliste = ['Berlin', 'Hamburg', 'München', 'Köln', 'Frankfurt a. M.', 
              'Stuttgart', 'Düsseldorf', 'Dortmund', 'Essen', 'Bremen']
Entfernungen = []
Entfernungen.append([  0, 288, 585, 575, 547, 633, 559, 494, 531, 392])
Entfernungen.append([289,   0, 775, 426, 493, 655, 400, 344, 365, 122])
Entfernungen.append([589, 775,   0, 577, 398, 220, 612, 604, 634, 748])
Entfernungen.append([579, 426, 576,   0, 193, 369, 42,  95,   73, 320])
Entfernungen.append([552, 492, 393, 193,   0, 210, 229, 219, 251, 445])
Entfernungen.append([637, 667, 231, 369, 203,   0, 404, 417, 426, 642])
Entfernungen.append([563, 408, 611,  38, 228, 404,   0,  71,  37, 302])
Entfernungen.append([498, 346, 605,  95, 221, 418,  69,   0,  36, 240])
Entfernungen.append([536, 374, 634,  74, 252, 427,  35,  37,   0, 267])
Entfernungen.append([397, 123, 748, 315, 441, 638, 289, 233, 254,   0])

print("Berechnung aller Routen wurde begonnen.")
route = optimal_solution_with_brute_force(Entfernungen)
print("Berechnung aller Routen wurde abgeschlossen.")
print("Länge der optimalen Route: ", Strecke_der_Route(Entfernungen, route))
for index in route:
    print(Stadtliste[index])
