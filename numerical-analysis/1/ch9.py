import sys
print('The command line arguments are:')
for i in sys.argv:
    print (i)
    print ('\n\nThe PYTHONPATH is', sys.path, '\n')

from math import sqrt
print ("Square root of 16 is", sqrt(16))

if __name__ == '__main__':
    print ('This program is being run by itself')
else:
    print ('I am being imported from another module')


import mymodule
mymodule.say_hi()
print ('Version', mymodule.__version__)

from mymodule import say_hi, __version__
say_hi()
print ('Version', __version__)

from mymodule import *

import sys

print(dir(sys))
print(dir())

a = 5
print(dir())
del a
print(dir())