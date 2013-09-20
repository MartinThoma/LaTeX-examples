"""from math import exp, log

def iterate(x):
    #return x - (2.0*x - exp(-x))/(2.0+exp(-x)) #Newton
    #return 0.5*exp(-x) #F_1
    return (-1)*log(2.0*x) #F_2

x = 0.9
for i in range(10):
    print (i, x)
    x = iterate(x)
"""
from math import log
f = lambda x: -log(2*x)

x = 0.35173371124919582602
#x = 0.3517337112491958260249093009299510651715
for i in range(200):
    print("x 0.35173371124919582602")
    print("x 0.3517337112491958260249093009299510651715")
    print("%i %.30f" % (i, x))
    x = f(x)
