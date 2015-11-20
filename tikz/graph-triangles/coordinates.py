def give_coordinates(n):
    for y in range(0, n):
        for x in range(y, 2*n-y, 2):
            print(x, y)
        print("")

give_coordinates(5)
