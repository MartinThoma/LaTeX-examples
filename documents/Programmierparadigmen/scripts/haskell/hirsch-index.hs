import Data.List --sort und reverse

hIndex :: (Num a, Ord a) => [a] -> a
hIndex l = helper (reverse (sort l)) 0
    where helper [] acc = acc
          helper (z:ls) acc
            | z > acc   = helper ls (acc + 1)
            | otherwise = acc

-- Alternativ
hindex1 = length . takeWhile id . zipWith (<=) [1..] . reverse . sort
hindex2 = length . takeWhile (\(i, n) -> n >= i) . zip [1..] . reverse . sort