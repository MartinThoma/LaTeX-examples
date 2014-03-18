splitWhen :: (a -> Bool) -> [a] -> ([a], [a])
splitWhen _ [] = ([], [])
splitWhen p (x:xs)
        | p x       = ([], x:xs)
        | otherwise = let (ys, zs) = splitWhen p xs 
            in (x:ys, zs)
-- >>> splitWhen even [1,2,3]
-- ([1],[2,3])

group :: Eq a => [a] -> [[a]]
group [] = []
group (x:xs) = let (group1, rest) = splitWhen (/=x) xs
        in (x:group1) : group rest

encode :: Eq a => [a] -> [(a, Int)]
encode xs = map (\x -> (head x, length x)) (group xs)

decode [] = []
decode ((x,n):xs) = replicate n x ++ decode xs
-- alternativ
decode = concat . (map (\(x,n)->replicate n x))
