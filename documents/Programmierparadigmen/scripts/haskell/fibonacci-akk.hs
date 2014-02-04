fibAkk n n1 n2
    | (n == 0) = n1
    | (n == 1) = n2
    | otherwise = fibAkk (n - 1) n2 (n1 + n2)
fib n = fibAkk n 0 1
