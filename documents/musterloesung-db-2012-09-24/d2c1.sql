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


Weitere Erklärungen:
Ansatz:
1. Suche alle Personenpaare, die beide <id> als Freund haben (wobei
   nur ungleiche paare gesucht sind, da man nicht mit sich selbst befreundet
   sein kann)
2. Prüfe über die Menge dieser Paare, welche noch nicht befreundet sind

Dazu:
1. SELECT f1.person2, f2.person2 FROM FriendshipSymmetric f1
   JOIN FriendshipSymmetric f2 ON f1.person1 = f2.person1
   WHERE f1.person2 != f2.person2
   AND f1.person1 = <id>;
2. Ein LEFT JOIN ergänzen, um zu ermitteln, welche Paare nicht tatsächlich
   in FriendshipSymmetric stehen (diese werden NULL joinen). Daher nach NULL
   selektieren


Beispielhaftes Ergebnis für gegebene Situation und id=4:
"1","5"
"2","5"
"3","5"
"5","1"
"5","2"
"5","3"
