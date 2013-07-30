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


Ohne EXCEPT (da ich mir nicht sicher bin, ob es nun SQL-Standard
ist oder nicht, z.B. SQLite kenn kein EXCEPT, auf einer Übersicht
stand es aber bei SQL89 angehakt dabei).
Hinweis: NOT EXISTS ist True, gdw die Unterabfrage genau 0
Zeilen enthält.

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
