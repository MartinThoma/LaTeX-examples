SELECT name FROM Berater
    JOIN Kunden ON Kunden.berater_id = Berater.berater_id 
    WHERE Kunden.name = "Müller"
