binom :: (Eq a, Num a, Num a1) => a -> a -> a1
binom n k =
    if (k==0) || (k==n)
    then 1
    else binom (n-1) (k-1) + binom (n-1) k
