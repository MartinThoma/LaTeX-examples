CREATE VIEW Beratungsanzahl AS (
    SELECT berater_id, count(DISTINCT Berater.berater_id) AS Anzahl
    FROM Berater
    FULL OUTER JOIN Kunden ON Berater.berater_id = Kunden.berater_id
    GROUP BY berater_id
)
