CREATE VIEW Beratungsanzahl AS (
    SELECT berater_id, COUNT(kb.kunden_id) AS anzahl
    FROM Berater b
    LEFT OUTER JOIN Kunden2Berater kb ON b.berater_id = kb.berater_id
    GROUP BY berater_id
)
