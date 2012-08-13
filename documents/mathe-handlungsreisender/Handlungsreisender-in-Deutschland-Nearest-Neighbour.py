#!/usr/bin/python
# -*- coding: utf-8 -*-

def nearest_neighbour(Entfernungen):
    """ Entfernungen: Entfernungen[x][y] gibt die Länge der Strecke von x nach
                      y als integer an.
        return: route als Liste, z.B. [0,3,4,1,2] 
        Es wird immer mit der Stadt 0 begonnen. """
    route = []
    cities = len(Entfernungen)
    maxEntfernung = max([item for sublist in Entfernungen for item in sublist])
    aktuelleCity = routenLaenge = 0
    for i in xrange(0, cities):
        route.append(aktuelleCity)
        for sublist in Entfernungen:
            sublist[aktuelleCity] = maxEntfernung + 1
        aktuelleCity = Entfernungen[aktuelleCity].index( min(Entfernungen[aktuelleCity]) )
        routenLaenge+= Entfernungen[route[-1]][aktuelleCity]

    print("Routenlänge: %i" % routenLaenge)
    return route

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
Stadtliste = ['Berlin', 'Hamburg', 'München', 'Köln', 'Frankfurt a. M.', 
              'Stuttgart', 'Düsseldorf', 'Dortmund', 'Essen', 'Bremen']

for city in nearest_neighbour(Entfernungen):
    print("%s" % Stadtliste[city])
