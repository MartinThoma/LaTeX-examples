fak :: (Eq a, Num a) => a -> a
fak n = if (n==0) then 1 else n * fak (n-1)
