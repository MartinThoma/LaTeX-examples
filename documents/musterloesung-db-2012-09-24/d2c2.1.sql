SELECT f1.person2, f2.person2 
FROM (
    SELECT * FROM FriendshipSymmetric WHERE person1 = 4
    ) f1
JOIN
    (
        SELECT * FROM FriendshipSymmetric WHERE person1 = 4
    ) f2 ON f1.person1 = f2.person1
WHERE f1.person2 != f2.person2
    AND NOT EXISTS 
    (
        SELECT * FROM FriendshipSymmetric f WHERE f.person1 = f1.person2 AND f.person2 = f2.person2
    )
