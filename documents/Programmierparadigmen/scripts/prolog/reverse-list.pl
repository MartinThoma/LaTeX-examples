rev([], []).
rev([X|Xs], Ys) :- rev(Xs, Zs), append(Zs, [X], Ys).

?- rev([1,2,3,4,5], L).
L = [5, 4, 3, 2, 1].