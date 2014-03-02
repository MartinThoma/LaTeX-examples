data People = Person String Int
jogi :: People
jogi = Person "Joachim Löw" 50

isAdult :: People -> Bool
isAdult (Person name age) = (age >= 18)