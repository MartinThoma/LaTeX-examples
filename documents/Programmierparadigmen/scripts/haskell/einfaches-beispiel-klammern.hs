f :: Floating a => a -> a
f x = sin x / x

g :: Floating a => a -> a
g x = x * (f (x*x))
