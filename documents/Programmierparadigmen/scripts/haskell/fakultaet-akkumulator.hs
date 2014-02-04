fakAcc :: (Eq a, Num a) => a -> a -> a
fakAcc n acc = if (n==0) 
               then acc 
               else fakAcc (n-1) (n*acc)

fak :: (Eq a, Num a) => a -> a
fak n = fakAcc n 1
