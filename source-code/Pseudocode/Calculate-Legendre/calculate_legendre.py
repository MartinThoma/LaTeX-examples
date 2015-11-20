#!/usr/bin/env python
# -*- coding: utf-8 -*-


def is_prime(a):
    """
    Check if `a` is a prime number.

    Parameters
    ----------
    a : int, a >= 2
    """
    return all(a % i for i in xrange(2, a))


# http://stackoverflow.com/a/14793082/562769
def factorize(n):
    factors = []

    p = 2
    while True:
        # while we can divide by smaller number, do so
        while(n % p == 0 and n > 0):
            factors.append(p)
            n = n / p
        p += 1  # p is not necessary prime, but n%p == 0 only for prime numbers
        if p > n / p:
            break
    if n > 1:
        factors.append(n)
    return factors


def calculate_legendre(a, p):
    """
    Calculate the legendre symbol (a, p) with p is prime.
    The result is either -1, 0 or 1

    >>> calculate_legendre(3, 29)
    -1
    >>> calculate_legendre(111, 41) # Beispiel aus dem Skript, S. 114
    -1
    >>> calculate_legendre(113, 41) # Beispiel aus dem Skript, S. 114
    1
    >>> calculate_legendre(2, 31)
    1
    >>> calculate_legendre(5, 31)
    1

    # http://math.stackexchange.com/q/221223/6876
    >>> calculate_legendre(150, 1009)
    1

    # http://math.stackexchange.com/q/221223/6876
    >>> calculate_legendre(25, 1009)
    1

    # http://math.stackexchange.com/q/221223/6876
    >>> calculate_legendre(2, 1009)
    1

    # http://math.stackexchange.com/q/221223/6876
    >>> calculate_legendre(3, 1009)
    1
    """
    if a >= p or a < 0:
        return calculate_legendre(a % p, p)
    elif a == 0 or a == 1:
        return a
    elif a == 2:
        if p % 8 == 1 or p % 8 == 7:
            return 1
        else:
            return -1
    elif a == p-1:
        if p % 4 == 1:
            return 1
        else:
            return -1
    elif not is_prime(a):
        factors = factorize(a)
        product = 1
        for pi in factors:
            product *= calculate_legendre(pi, p)
        return product
    else:
        if ((p-1)/2) % 2 == 0 or ((a-1)/2) % 2 == 0:
            return calculate_legendre(p, a)
        else:
            return (-1)*calculate_legendre(p, a)

if __name__ == "__main__":
    import doctest
    doctest.testmod()
