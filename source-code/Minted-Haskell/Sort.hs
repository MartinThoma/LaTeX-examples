module Sort where

    -- Aufgabe 2
    -- insert list el: sorts an elmenet el into a sorted list
    insert :: (Ord t) => [t] -> t -> [t]
    insert [] x = [x]
    insert [a] x
        | x < a     = [x, a]
        | otherwise = [a, x]
    insert (a:b:qs) x
        | x < a     = [x,a,b] ++ qs
        | x < b     = [a,x,b] ++ qs
        | otherwise = [a,b] ++ insert qs x

    -- sortH q r: Sorts an unsorted list r into a sorted list q
    insertH :: (Ord t) => [t] -> [t] -> [t]
    insertH q [] = q
    insertH q [r] = insert q r
    insertH q (r:rest) = insertH (insert q r) rest

    -- insertSort list: sorts list
    insertSort :: (Ord t) => [t] -> [t]
    insertSort [] = []
    insertSort [a] = [a]
    insertSort (a:qs) = insertH [a] qs

    -- Aufgabe 3
    merge :: (Ord t) => [t] -> [t] -> [t]
    merge [] x = x
    merge x [] = x
    merge (x:xs) (y:ys)
        | x <= y    = x : merge xs (y:ys) 
        | otherwise = y : merge ys (x:xs)

    mergeSort :: (Ord t) => [t] -> [t]
    mergeSort [] = []
    mergeSort [x] = [x]
    mergeSort xs = merge (mergeSort top) (mergeSort bottom) where
                    (top, bottom) = splitAt (div (length xs) 2) xs

    -- Aufgabe 4
    -- Teste 
    isSorted :: (Ord t) => [t] -> Bool
    isSorted [] = True
    isSorted [a] = True
    isSorted (a:b:xs)
        | (a <= b) && isSorted xs = True
        | otherwise = False

    insertSortedIsSorted :: (Ord t) => [t] -> Bool
    insertSortedIsSorted xs = isSorted(insertSort xs)

    mergeSortedIsSorted :: (Ord t) => [t] -> Bool
    mergeSortedIsSorted xs = isSorted(mergeSort xs)
