qsort []     = []
qsort (p:ps) = (qsort (filter (\x -> x<=p) ps)) 
          ++ p:(qsort (filter (\x -> x> p) ps))
