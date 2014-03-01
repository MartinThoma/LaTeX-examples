summer :: [Int] -> Int
summer = foldr (-) 0

summel :: [Int] -> Int
summel = foldl (-) 0

main :: IO ()
main = do
	print (summer [1,2,3])
	-- 0-(1-(2-3)) = 0-(1-(-1)) = 2
	print (summel [1,2,3])
	-- ((0-1)-2)-3 = -6