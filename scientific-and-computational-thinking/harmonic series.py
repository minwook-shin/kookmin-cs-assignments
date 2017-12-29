from math import log


def h(n):
    gamma = 0.57721566490153286060651209008240243104215933593992
    return gamma + log(n) + 0.5/n - 1./(12*n*2) + 1./(120*n*4)


print(h(10))
