splits(L, ([], L)).
splits([X|L], ([X|S], E)) :- splits(L, (S, E)).