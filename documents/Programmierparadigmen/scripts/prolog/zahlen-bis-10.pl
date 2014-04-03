nat(1).
nat(X) :- nat(X1),X is X1+1.
nat10(X) :- nat(X), ( X > 10 -> !, fail ; true ).