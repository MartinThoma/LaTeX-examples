CREATE VIEW AlwaysParticipating AS (
    SELECT player_id, name
    FROM Player
    JOIN Participation ON Player.player_id = Participation.player_id
    HAVING SUM(Participation.cup_id) =
        (
            SELECT SUM(cup_id)
            FROM cup_id
        )
)
