data Tree a = Empty | Node a (Tree a) (Tree a)
                    deriving (Show)