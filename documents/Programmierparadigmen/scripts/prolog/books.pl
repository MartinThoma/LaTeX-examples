% Those are the books:
book(a).
book(b).
book(c).
book(d).
book(e).
book(f).

% This is how 'touching' works:
touching(X,Y):- touching(Y,X). % touching is symmetric
touching(p1,p2).
touching(p2,p3).
touching(p3,p4).
touching(p3,p5).
touching(p3,p6).
touching(p4,p5).
touching(p5,p6).

% List all possible positions:
position(a):- p1,p2,p3,p4,p5,p6.
position(b):- p1,p2,p3,p4,p5,p6.
position(c):- p1,p2,p3,p4,p5,p6.
position(d):- p1,p2,p3,p4,p5,p6.
position(e):- p1,p2,p3,p4,p5,p6.
position(f):- p1,p2,p3,p4,p5,p6.

% Every position has one book
getBook(p1) :- a,b,c,d,e,f.
getBook(p2) :- a,b,c,d,e,f.
getBook(p3) :- a,b,c,d,e,f.
getBook(p4) :- a,b,c,d,e,f.
getBook(p5) :- a,b,c,d,e,f.
getBook(p6) :- a,b,c,d,e,f.

% Add your facts:
not(touching(position(a),position(d))).
position(e):- p5,p2.
% C touches exactly two books: eventually something like aggregate_all(count, touching(e,X), Count):-2.
position(c):- p2, p4,p6.
touching(position(a),position(f)).
touching(position(e),position(f)).