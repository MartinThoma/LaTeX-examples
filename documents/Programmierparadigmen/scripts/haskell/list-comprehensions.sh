Prelude> let mylist = [1,2,3,4,5,6]
Prelude> let test = [x | x <- mylist, x>2]
Prelude> test
[3,4,5,6]
