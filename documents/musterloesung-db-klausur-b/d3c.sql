SELECT name FROM Berater
    JOIN Kunden, Kunden2Berater, Berater 
    WHERE Kunden.name = "Müller"
