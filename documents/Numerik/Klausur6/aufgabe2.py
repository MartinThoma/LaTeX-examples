from math import exp, log

def iterate(x):
    #return x - (2.0*x - exp(-x))/(2.0+exp(-x)) #Newton
    #return 0.5*exp(-x) #F_1
    return (-1)*log(2.0*x) #F_2

x = 0.9
for i in range(10):
    print (i, x)
    x = iterate(x)
