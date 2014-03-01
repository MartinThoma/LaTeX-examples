g a b c
	| c > 0     = b
	| otherwise = a

main = do
	print (g (1/0) 2 3)