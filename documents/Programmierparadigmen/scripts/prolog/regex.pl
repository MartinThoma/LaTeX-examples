matches(\varepsilon, []).

matches(C, [C]) :- atom(C), !.

matches(\cup(A, _), S) :- matches(A, S).
matches(\cup(_, B), S) :- matches(B, S).

matches(\cdot(A, B), S) :- append(S1, S2, S),
                           matches(A, S1),
                           matches(B, S2).

matches(*(_), []).
matches(*(A), S) :- append(S1, S2, S),
                    not(S1=[]),
                    matches(A, S1),
                    matches(*(A), S2).