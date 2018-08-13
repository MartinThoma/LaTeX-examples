from math import ceil


def round_up(n, prime):
    return int(ceil(float(n) / prime))


def get_primes_below_n(n=1000000):
    """
    Get a list of all primes below n.

    Parameters
    ----------
    n : int

    Returns
    -------
    prime_list : list

    Examples
    --------
    >>> get_primes_below_n(10)
    [2, 3, 5, 7]
    """
    is_prime_table = [True] * n
    is_prime_table[0] = False
    is_prime_table[1] = False
    prime_list = []

    for currentPrime in range(2, n):
        if not is_prime_table[currentPrime]:
            continue
        prime_list.append(currentPrime)
        for multiplicant in range(2, round_up(n, currentPrime)):
            is_prime_table[multiplicant * currentPrime] = False
    return prime_list
