cbal_tree(0,nil) :- !.
cbal_tree(N,t(x,L,R)) :- N > 0,
    N0 is N - 1, 
    N1 is N0//2, N2 is N0 - N1,
    distrib(N1,N2,NL,NR),
    cbal_tree(NL,L), cbal_tree(NR,R).

distrib(N,N,N,N) :- !.
distrib(N1,N2,N1,N2).
distrib(N1,N2,N2,N1).