#!/usr/bin/swipl -q -t main -f
% Find three digits X, Y and Z such that
% XYZ in base10 is equal to ZYX in base9

is_solution(X, Y, Z) :- between(0,9,X),
                        between(0,9,Y),
                        between(0,9,Z),
                        Base10 is (100*X + 10*Y + Z),
                        Base9 is (9*9*Z+9*Y+X),
                        Base10 = Base9.

main :-
    is_solution(X, Y, Z),
    format("solution: ~w ~w ~w\n", [X,Y,Z]),
    false. % make sure that all solutions get printed