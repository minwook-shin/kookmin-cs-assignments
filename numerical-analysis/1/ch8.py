def say_hello():
    print ('hello world')

say_hello()
say_hello()

def print_max(a,b):
    if a > b:
        print (a,'is maximum')
    elif a == b:
        print (a,'is equal to', b)
    else:
        print (b,'is maximum')

print_max(3, 4)
x = 5
y = 7

print_max(x, y)

x = 50
def func(x):
    print ('x is', x)
    x = 2
    print ('Changed local x to', x)
func(x)
print ('x is still', x)

x = 50
def func():
    global x
    print ('x is', x)
    x = 2
    print ('Changed global x to', x)
func()
print ('Value of x is', x)

def say(message, times=1):
    print (message * times)

say('Hello')
say('World', 5)

def func(a, b=5, c=10):
    print ('a is', a, 'and b is', b, 'and c is', c)
func(3, 7)
func(25, c=24)
func(c=50, a=100)

def total(initial=5, *numbers, **keywords):
    count = initial
    for number in numbers:
        count += number
    for key in keywords:
        count += keywords[key]
    return count
print (total(10, 1, 2, 3, vegetables=50, fruits=100))

def maximum(x, y):
    if x > y:
        return x
    elif x == y:
        return 'The numbers are equal'
    else:
        return y
print (maximum(2, 3))

def some_function():
    pass

def print_max(x, y):
    '''Prints the maximum of two numbers.
    The two values must be integers.'''
    x = int(x)
    y = int(y)
    if x > y:
        print (x, 'is maximum')
    else:
        print (y, 'is maximum')
print_max(3, 5)
print (print_max.__doc__)