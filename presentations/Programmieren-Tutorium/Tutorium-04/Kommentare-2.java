//Konstuktor 
/** erzeugt ein neues Objekt und initialisiert die Attribute */
Gears(byte chainwheel0, byte rearsprocket0, int price0) {
    chainwheel = chainwheel0;
    rearsprocket = rearsprocket0;
    price = price0;
}

// Methode
/** gibt die Anzahl der Gänge zurück */
short getNumberOfGears() {
    short numbergears;
    
    numbergears =  (short) (rearsprocket * chainwheel);
    return numbergears;
}
