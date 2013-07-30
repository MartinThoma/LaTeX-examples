SELECT f1.person2, f2.person2 
FROM (
    SELECT * FROM FriendshipSymmetric WHERE person1 = <id>
) f1
JOIN ON
(
    SELECT * FROM FriendshipSymmetric WHERE person1 = <id>
) f2
EXCEPT
(
    SELECT * FROM FriendshipSymmetric
)
WHERE f1.person2 != f2.person2
