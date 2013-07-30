SELECT berater_id, name, anzahl
    FROM Beratungsanzahl
    JOIN Berater ON Berater.berater_id = Beratungsanzahl.berater_id
    WHERE anzahl = (SELECT MAX(anzahl) FROM Beratungsanzahl)
