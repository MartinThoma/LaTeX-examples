member(X,[X|R]).
member(X,[Y|R]) :- member(X,R).