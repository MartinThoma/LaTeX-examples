public boolean isStreetLegal() {
    if(bell==true && light==true) { //Wenn das Fahrrad eine Klingel und ein Licht hat...
        legal = true; //dann ist es auf der Straße zugelassen
    }
    else { //wenn es keine Beleuchtung und/oder Licht hat, ...
        legal = false; // dann ist es nicht zugelassen
    }
    return legal; //Zurückgabe des Attributs ob es zugelassen ist
}

public int getPriceFull(){ //Methode zur Berechnung des Gesamtpreises des Fahrrades
    int priceFull = shift.getPrice() + price + wheels.getPrice(); /*
    Berechnung des Preises durch Addition der Einzelpreise*/
    return priceFull; //Zurückgabe des Gesamtpreises
}
