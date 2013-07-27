SELECT f1.person2, f2.person2 
FROM FriendshipSymmetric f1
JOIN FriendshipSymmetric f2 
    ON f1.person1 = f2.person1
LEFT JOIN FriendshipSymmetric f3 
    ON f1.person2 = f3.person1 AND f2.person2 = f3.person2
WHERE f1.person2 != f2.person2
    AND f1.person1 = <id>
    AND p3.person1 IS NULL 
    AND p3.person2 IS NULL
