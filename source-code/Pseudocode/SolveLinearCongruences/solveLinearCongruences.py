#!/usr/bin/env python
# -*- coding: utf-8 -*-


def extended_euclidean_algorithm(a, b):
    """
    Calculates gcd(a,b) and a linear combination such that
    gcd(a,b) = a*x + b*y

    As a side effect:
    If gcd(a,b) = 1 = a*x + b*y
    Then x is multiplicative inverse of a modulo b.
    """
    aO, bO = a, b

    x = lasty = 0
    y = lastx = 1
    while (b != 0):
        q = a/b
        a, b = b, a % b
        x, lastx = lastx-q*x, x
        y, lasty = lasty-q*y, y

    return {
        "x": lastx,
        "y": lasty,
        "gcd": aO * lastx + bO * lasty
    }


def solve_linear_congruence_equations(rests, modulos):
    """
    Solve a system of linear congruences.

    Examples
    --------
    >>> solve_linear_congruence_equations([4, 12, 14], [19, 37, 43])
    {'congruence class': 22804, 'modulo': 30229}
    """
    assert len(rests) == len(modulos)
    x = 0
    M = reduce(lambda x, y: x*y, modulos)

    for mi, resti in zip(modulos, rests):
        Mi = M / mi
        s = extended_euclidean_algorithm(Mi, mi)["x"]
        e = s * Mi
        x += resti * e
    return {"congruence class": ((x % M) + M) % M, "modulo": M}

if __name__ == "__main__":
    import doctest
    doctest.testmod()
