fakAcc n acc = if (n==0) 
               then acc 
               else fakAcc (n-1) (n*acc)
fak n = fakAcc n 1
