type Church t = (t -> t) -> t -> t

int2church :: Integer -> Church t
int2church 0 s z = z
int2church n s z = int2church (n - 1) s (s z)

church2int :: Church Integer -> Integer
church2int n = n (+1) 0