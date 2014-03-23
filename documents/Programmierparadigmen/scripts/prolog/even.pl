even(0).
even(X) :- X>0, X1 is X-1, odd(X1).

odd(1).
odd(X) :- X>1, X1 is X-1, even(X1).