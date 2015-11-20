#!/usr/bin/env python
# -*- coding: utf-8 -*-


def get_next(n, i, damen_pos):
    for i in range(n):
        candidates = set(list(range(n)))
        candidates -= set(damen_pos)
        candidates -= set(list(range(damen_pos[i]+1)))
        candidates = list(candidates)
        if len(candidates) > 0:
            damen_pos[i] = candidates[0]
            return i, damen_pos
        else:
            damen_pos = damen_pos[0:i] + [0]*(n-i)
            i -= 1


def is_attacked(damen, x, y):
    """ Wird das Feld (x,y) von einer der Damen angegriffen? """
    for dy, dx in enumerate(damen[:y]):
        if dx == x or dy == y or abs(x-dx) == abs(y-dy):
            return True
    return False


def finde_loesung(n):
    """ Platziere n Damen so auf einem n×n Feld,
        sodass sich keine Damen schlagen.
    """
    # damen[i] ist die x-position von Dame i in Zeile i
    damen = [0]*n
    i = 1
    solutions = []
    while 0 <= i < n:
        while not is_attacked(damen, damen[i], i):
            if i == n-1:
                yield damen
                break
            i += 1
        i, damen = get_next(n, i, damen)


def alle_loesungen(n):
    generator = finde_loesung(n)
    return list(generator)

print(len(alle_loesungen(11)))
