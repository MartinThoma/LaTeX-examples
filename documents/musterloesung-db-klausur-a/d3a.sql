CREATE VIEW GoalsPerPlayer AS (
    SELECT player_id, name, team, SUM(goals) AS sum_goals
        FROM Player
        JOIN Participation ON Participation.player_id = Player.player_id
        GROUP BY player_id 
)
