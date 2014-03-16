fib(0, A, _, A).
fib(N, A, B, F) :- N1 is N - 1, 
                   Sum is A + B, 
                   fib(N1, B, Sum, F).
fib(N, F) :- fib(N, 0, 1, F).