module Arithmetik where

    -- Aufgabe 1.1
    -- Berechnung der Potenz durch e-faches multiplizieren von b
    -- Benötigt e Rekursionsschritte
    pow1 :: Double -> Int -> Double
    pow1 b 0 = 1
    pow1 b e = b * (pow1 b (e-1))

    -- Aufgabe 1.2
    -- Berechnung der Potenz pow2(b,e) = b^e
    -- Benötigt O(log_2(e)) Rekursionsschritte
    pow2 :: Double -> Int -> Double
    pow2 b 0 = 1
    pow2 b e = if odd e
               then b * pow2 b (e-1)
               else pow2 (b*b) (quot e 2)

    -- Aufgabe 1.3
    -- Berechnung der Potenz pow3(b,e) = b^e mit einer Hilfsfunktion
    pow3 :: Double -> Integer -> Double
    pow3 b e
      | e < 0     = error "Der Exponent muss nicht-negativ sein"
      | otherwise = pow3h b e 1 where 
                    pow3h b e acc
                      | e == 0    = acc
                      | odd e     = pow3h b (e-1) (acc*b)
                      | otherwise = pow3h (b*b) (quot e 2) acc

    -- Aufgabe 1.4
    -- Suche größte natürliche Zahl x, sodass x^e <= r
    -- Prinzipiell könnte e auch Double sein, aber wenn x und e
    -- natürliche Zahlen sind, könnte man o.B.d.A r abrunden.
    root :: Int -> Int -> Int
    root e r = rootH 0 r
        where rootH a b
                | b-a == 1  = a
                | floor (pow1 (fromIntegral(quot (a+b) 2)) e) <= r = rootH (quot (a+b) 2) b
                | otherwise = rootH a (quot (a+b) 2)

    -- Aufgabe 1.5: Primzahlcheck
    isPrime :: Integer -> Bool
    isPrime 0 = False
    isPrime 1 = False
    isPrime x = not (hasDivisor (root 2 x) 2)
            where hasDivisor upperBound i
                    | i > upperBound = False
                    | mod x i == 0   = True
                    | otherwise      = hasDivisor upperBound (i+1)
