module Intersect where
intersect :: (Ord t) => [t] -> [t] -> [t]
intersect a [] = []
intersect [] a = []
intersect (x:xs) (y:ys)
        | x == y = x : intersect xs ys
        | x < y  = intersect xs (y:ys)
        | y > y  = intersect (x:xs) ys

intersectAll :: (Ord t) => [[t]] -> [t]
intersectAll (l:ls) = (foldr intersect l) ls
intersectAll []     = undefined

multiples n = [n*k | k <- [1..]]
commonMultiples a b c = intersectAll [ multiples n | n <- [a,b,c]]