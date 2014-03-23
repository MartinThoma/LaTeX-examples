append([],L,L).
append([X|R],L,[X|T]) :- append(R,L,T).