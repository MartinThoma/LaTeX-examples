mapT :: (t -> s) -> Tree t -> Tree s
mapT f (Node x ts) = Node (f x) (map (mapT f) ts)

reduceT :: (t -> t -> t) -> Tree t -> t
reduceT f (Node x ts) = foldl f x (map (reduceT f) ts)