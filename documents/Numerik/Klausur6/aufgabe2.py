from math import exp


def iterate(x, times=1):
    # x = x - (2.0*x - exp(-x))/(2.0+exp(-x)) #Newton
    x = 0.5*exp(-x)  # F_1
    # x = (-1)*log(2.0*x) #F_2

    if times > 0:
        x = iterate(x, times-1)

    return x

print(iterate(0.5, 6))
