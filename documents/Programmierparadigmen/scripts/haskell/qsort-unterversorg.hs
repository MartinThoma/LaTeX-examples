qsort []     = []
qsort (p:ps) = (qsort (filter (<=p) ps)) 
          ++ p:(qsort (filter (> p) ps))
