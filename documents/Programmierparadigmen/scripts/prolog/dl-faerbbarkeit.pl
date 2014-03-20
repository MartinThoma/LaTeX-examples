farbe(blau).
farbe(gelb).
farbe(gruen).
nachbar(X, Y) :- farbe(X), farbe(Y), X \= Y.
deutschland(SH,MV,HH,HB,NI,ST,BE,BB,SN,NW,HE,TH,RP,SL,BW,BY) :-
nachbar(SH, NI), nachbar(SH, HH), nachbar(SH, MV),
nachbar(HH, NI),
nachbar(MV, NI), nachbar(MV, BB),
nachbar(NI, HB), nachbar(NI, BB), nachbar(NI, ST), nachbar(NI, TH),
nachbar(NI, HE), nachbar(NI, NW),
nachbar(ST, BB), nachbar(ST, SN), nachbar(ST, TH),
nachbar(BB, BE), nachbar(BB, SN),
nachbar(NW, HE), nachbar(NW, RP),
nachbar(SN, TH), nachbar(SN, BY),
nachbar(RP, SL), nachbar(RP, HE), nachbar(RP, BW),
nachbar(HE, BW), nachbar(HE, TH), nachbar(HE, BY),
nachbar(TH, BY),
nachbar(BW, BY).