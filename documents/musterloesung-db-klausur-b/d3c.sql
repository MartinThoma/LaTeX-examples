SELECT name FROM Berater b
    JOIN Kunden2Berater  kb ON kb.berater_id = b.berater_id
    JOIN Kunden k ON k.kunden_id = kb.kunden_id
    WHERE k.name = "Müller"
