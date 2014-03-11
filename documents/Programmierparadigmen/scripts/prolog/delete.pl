remove([(X,A)|L],X,[(X,ANew)|L]) :- A>0, ANew is A-1.
remove([X|L],Y,[X|L1]) :- remove(L,Y,L1).
