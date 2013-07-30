SELECT f1.person2, f2.person2 
    FROM FriendshipSymmetric f1
    JOIN FriendshipSymmetric f2 ON f1.person1 = f2.person1
    WHERE f1.person2 != f2.person2
        AND f1.person1 = <id>;
