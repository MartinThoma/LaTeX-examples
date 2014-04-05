istree(nil).
istree(t(_,L,R)) :- istree(L), istree(R).