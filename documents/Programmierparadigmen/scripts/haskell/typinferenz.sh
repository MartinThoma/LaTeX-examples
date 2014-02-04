Prelude> let x = \x -> x*x
Prelude> :t x
x :: Integer -> Integer
Prelude> x(2)
4
Prelude> x(2.2)
<interactive>:6:3:
    No instance for (Fractional Integer)
      arising from the literal `2.2'
    Possible fix: add an instance declaration for 
                        (Fractional Integer)
    In the first argument of `x', namely `(2.2)'
    In the expression: x (2.2)
    In an equation for `it': it = x (2.2)


Prelude> let mult = \x y->x*y
Prelude> mult(2,5)
<interactive>:9:5:
    Couldn't match expected type `Integer' with 
                actual type `(t0, t1)'
    In the first argument of `mult', namely `(2, 5)'
    In the expression: mult (2, 5)
    In an equation for `it': it = mult (2, 5)
Prelude> mult 2 5
10
Prelude> :t mult
mult :: Integer -> Integer -> Integer

Prelude> let concat = \x y -> x ++ y
Prelude> concat [1,2,3] [3,2,1]
[1,2,3,3,2,1]
Prelude> :t concat
concat :: [a] -> [a] -> [a]

