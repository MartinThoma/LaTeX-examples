type Polynom = [Double]

add :: Polynom -> Polynom -> Polynom
add a [] = a
add [] a = a
add (x:xs) (y:ys) = (x+y) : add xs ys

eval :: Polynom -> Double -> Double
eval [] x = 0
eval (p:ps) x = p + x * (eval ps x)
-- alternativ:
eval p x = foldr (\element rest ->element+x*rest) 0 p

deriv :: Polynom -> Polynom
deriv [] = []
deriv p = zipWith (*) [1..] (tail p)