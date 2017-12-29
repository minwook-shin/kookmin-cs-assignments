from math import *


class circle:
    def __init__(self, radius=1):
        self.__radius = radius

    def set_r(self, r):
        self.__radius = r

    def get_r(self):
        return self.__radius

    def calc1(self):
        a = pi * self.__radius * self.__radius
        return a

    def calc2(self):
        c = 2 * pi * self.__radius
        return c


my_circle = circle(10)
print("반지름 =", my_circle.get_r())
print("넓이 =", my_circle.calc1())
print("반지름 =", my_circle.calc2())
