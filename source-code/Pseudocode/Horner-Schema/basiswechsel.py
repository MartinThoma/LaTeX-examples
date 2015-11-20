#!/usr/bin/env python
# -*- coding: utf-8 -*-


def string(zahl):
    if zahl <= 9:
        return str(zahl)
    else:
        return chr(55+zahl)


def horner(b, Z):
    ergebnis = ''
    while Z > 0:
        rest = Z % b
        ergebnis = string(rest) + ergebnis
        Z = (Z - rest)/b
    return ergebnis

if __name__ == "__main__":
    r = horner(16, 31562)
    print("Result:" + str(r))
