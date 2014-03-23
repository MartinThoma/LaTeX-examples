triples :: [(Integer, Integer, Integer)]
triples = [(x,y,z) | z <-[1..],
                     x <- [1..z],
                     y <- [1..z],
                     z^2 == x^2 + y^2
          ]