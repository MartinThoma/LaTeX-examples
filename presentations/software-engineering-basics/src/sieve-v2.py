from math import ceil


def round_up(n, prime):
    return int(ceil(float(n) / prime))


def get_primes_below_n(n=1000000):
    is_prime_table = [True] * n
    is_prime_table[0] = False
    is_prime_table[1] = False
    prime_list = []

    for current_number in range(2, n):
        if not is_prime_table[current_number]:
            continue
        prime_list.append(current_number)
        for multiplicant in range(2, round_up(n, current_number)):
            is_prime_table[multiplicant * current_number] = False
    return prime_list
