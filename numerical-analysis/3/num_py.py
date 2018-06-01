import numpy as np

a = np.array([1, 3, 0], float)
b = np.array([0, 3, 2], float)

print(a > b)
print(a==b)
print(a<=b)

c = a > b
print(c)

a = np.array([1, 3, 0], float)
print(a>2)

c = np.array([ True, False, False], bool)

print(any(c))
print(all(c))

a = np.array([1, 3, 0], float)
print(np.logical_and(a > 0, a < 3))

b = np.array([True, False, True], bool)
print(np.logical_not(b))

c = np.array([False, True, False], bool)
print(np.logical_or(b, c))

a = np.array([1, 3, 0], float)
print(np.where(a != 0, 1 / a, a))
print(np.where(a > 0, 3, 2))

a = np.array([[0, 1], [3, 0]], float)
print(a.nonzero())

a = np.array([1, np.NaN, np.Inf], float)
print(a)
print(np.isnan(a))
print(np.isfinite(a))

a = np.array([[6, 4], [5, 9]], float)
print(a >= 6)
print(a[a >= 6])

a = np.array([[6, 4], [5, 9]], float)
sel = (a >= 6)
print(a[sel])

a[np.logical_and(a > 5, a < 9)]
print(np.array([ 6.]))

a = np.array([2, 4, 6, 8], float)
b = np.array([0, 0, 1, 3, 2, 1], int)
print(a[b])

a = np.array([2, 4, 6, 8], float)
print(a[[0, 0, 1, 3, 2, 1]])

a = np.array([[1, 4], [9, 16]], float)
b = np.array([0, 0, 1, 1, 0], int)
c = np.array([0, 1, 1, 1, 1], int)
print(a[b,c])

a = np.array([2, 4, 6, 8], float)
b = np.array([0, 0, 1, 3, 2, 1], int)
print(a.take(b))

a = np.array([[0, 1], [2, 3]], float)
b = np.array([0, 0, 1], int)
print(a.take(b, axis=0))

print(a.take(b, axis=1))

a = np.array([0, 1, 2, 3, 4, 5], float)
b = np.array([9, 8, 7], float)
print(a.put([0, 3], b))

a = np.array([0, 1, 2, 3, 4, 5], float)
a.put([0, 3], 5)
print(a)

a = np.array([1, 2, 3], float)
b = np.array([0, 1, 1], float)
print(np.dot(a, b))

a = np.array([[0, 1], [2, 3]], float)
b = np.array([2, 3], float)
c = np.array([[1, 1], [4, 0]], float)
print(a)

print(np.dot(b, a))
print(np.dot(a, b))
print(np.dot(a, c))
print(np.dot(c, a))

a = np.array([1, 4, 0], float)
b = np.array([2, 2, 1], float)

print(np.outer(a, b))
print(np.inner(a, b))
print(np.cross(a, b))

a = np.array([[4, 2, 0], [9, 3, 7], [1, 2, 1]], float)
print(a)

print(np.linalg.det(a))

vals, vecs = np.linalg.eig(a)
print(vals)
print(vecs)

b = np.linalg.inv(a)
print(b)

print(np.dot(a, b))

a = np.array([[1, 3, 4], [5, 2, 3]], float)
U, s, Vh = np.linalg.svd(a)
print(U)
print(s)
print(Vh)

print(np.poly([-1, 1, 1, 10]))

print(np.roots([1, 4, -2, 3]))

print(np.polyint([1, 1, 1, 1]))

print(np.polyder([1./4., 1./3., 1./2., 1., 0.]))

print(np.polyval([1, -2, 0, 2], 4))

x = [1, 2, 3, 4, 5, 6, 7, 8]

y = [0, 2, 1, 3, 7, 10, 11, 19]

print(np.polyfit(x, y, 2))

a = np.array([1, 4, 3, 8, 9, 2, 3], float)

print(np.median(a))

a = np.array([[1, 2, 1, 3], [5, 3, 1, 8]], float)
c = np.corrcoef(a)
print(c)

print(np.cov(a))

np.random.seed(293423)
print(np.random.rand(5))
print(np.random.rand(2,3))
print(np.random.rand(6).reshape((2,3)))
print(np.random.random())
print(np.random.randint(5, 10))
print(np.random.poisson(6.0))

print(np.random.normal(1.5, 4.0))
print(np.random.normal())
print(np.random.normal(size=5))

l = list(range(10))
print(l)
np.random.shuffle(l)
print(l)

import scipy
# help(scipy)

import scipy
import scipy.interpolate