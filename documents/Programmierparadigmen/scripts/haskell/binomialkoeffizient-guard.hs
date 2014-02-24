binom :: (Eq a, Num a, Num a1) => a -> a -> a1
binom n k
    | (k==0) || (k==n) = 1
    | otherwise        = binom (n-1) (k-1) 
                         + binom (n-1) k