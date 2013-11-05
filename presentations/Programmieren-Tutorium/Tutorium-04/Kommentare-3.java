/**
 * Methode, die ein neues Stadtrad erstellt.
 * @return neues Stadtrad
 */
public Bike createCityBike() {        //Methodensignatur der Methode createCityBike
    Wheels cityWheels = new Wheels(559,50f,10000);        //Räder des Stadtrads erstellen
    Gears cityGears = new Gears(3,1,5000);                //Gangschaltung des Stadtrads erstellen
    Bike newCityBike = new Bike(cityGears, cityWheels, "Stahl", "CB105", true, true, 30000); //Stadtrad erstellen
    return newCityBike;        //Stadtrad zurückgeben
}
