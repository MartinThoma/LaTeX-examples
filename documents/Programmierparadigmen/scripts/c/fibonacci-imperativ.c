int fib(int n) {
    if (n < 0) {
        return -1;
    }

    int fib[2] = {0, 1}, tmp;

    for (; n > 0; n--) {
        tmp    = fib[1];
        fib[1] = fib[0] + fib[1];
        fib[0] = tmp;
    }
    return fib[0];
}