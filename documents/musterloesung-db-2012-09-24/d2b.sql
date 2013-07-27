CREATE VIEW FriendshipSymmetric AS (
    (
        SELECT person1, person2 
        FROM Friendship
    )
    UNION
    (
        SELECT person2 AS person1, person1 AS person2 
        FROM Friendship
    )
)
