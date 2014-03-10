data Bool   = False | True
data Color  = Red | Green | Blue | Indigo | Violet
data Tree a = Leaf a | Branch (Tree a) (Tree a)
data Point = Point Float Float deriving (Show)