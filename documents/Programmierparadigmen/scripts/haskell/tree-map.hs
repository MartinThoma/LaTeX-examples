data Tree t = Node t [Tree t]
reduceT :: (t -> t -> t) -> Tree t -> t
reduceT f (Node x []) = x
reduceT f (Node x [y]) = f x y
reduceT f (Node x (y:ys)) = reduceT f (f x y) ys