lengthof(L, 0) :- L == [].
lengthof([_|R], NewLength) :- lengthof(R,Length), NewLength is Length+1.