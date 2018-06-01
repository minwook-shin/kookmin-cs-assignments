import numpy
import numpy as np 


a = np.array([1, 4, 5, 8], float)
print(a)
print(type(a))

print(a[:2])

print(a[3])

a[0] = 5.
print(a)

a = np.array([[1, 2, 3], [4, 5, 6]], float)
print(a)
print(a[0,0])
print(a[0,1])

a = np.array([[1, 2, 3], [4, 5, 6]], float)
print(a[1,:])
print(a[:,2])
print(a[-1:,-2:])

print(a.shape)
print(a.dtype)

a = np.array([[1, 2 ,3 ],[4, 5, 6]],float)
print(len(a))

a = np.array([[1, 2, 3], [4, 5, 6]], float)
print(a in a)
print(0 in a)

a = np.array(range(10), float)

print(a)
a = a.reshape((5,2))
print(a)
print(a.shape)

a = np.array([1, 2, 3], float)
b = a
c = a.copy()
a[0] = 0
print(a)
print(b)
print(c)

a = np.array([1, 2, 3], float)
print(a.tolist())
print(list(a))

a = np.array([1, 2, 3], float)
s = a.tostring()
print(s)

print(np.fromstring(s))

a = np.array([1, 2, 3], float)
print(a)
a.fill(0)
print(a)

a = np.array(range(6), float).reshape((2, 3))
print(a)

print(a.transpose())

a = np.array([[1, 2, 3], [4, 5, 6]], float)
print(a)

print(a.flatten())

a = np.array([1,2], float)
b = np.array([3,4,5,6], float)
c = np.array([7,8,9], float)
print(np.concatenate((a, b, c)))

a = np.array([[1, 2], [3, 4]], float)
b = np.array([[5, 6], [7,8]], float)
print(np.concatenate((a,b)))
print(np.concatenate((a,b), axis=0))
print(np.concatenate((a,b), axis=1))

a = np.array([1, 2, 3], float)
b = np.array([1, 2, 3], float)
print(a)
print(a[:,np.newaxis])
print(a[:,np.newaxis].shape)
print(b[np.newaxis,:])
print(b[np.newaxis,:].shape)

print(np.arange(5, dtype=float))
print(np.arange(1, 6, 2, dtype=int))

print(np.ones((2,3), dtype=float))
print(np.zeros(7, dtype=int))

a = np.array([[1, 2, 3], [4, 5, 6]], float)
print(np.zeros_like(a))
print(np.ones_like(a))

print(np.identity(4, dtype=float))
print(np.eye(4,k=1, dtype=float))


a = np.array([1,2,3], float)
b = np.array([5,2,6], float)
print(a+b)
print(a-b)
print(a*b)
print(b/a)
print(b**a)

a = np.array([[1,2], [3,4]], float)
b = np.array([[2,0], [1,3]], float)
print(a * b)

# a = np.array([1,2,3], float)
# b = np.array([4,5], float)
# print(a + b)

a = np.array([[1, 2], [3, 4], [5, 6]], float)
b = np.array([-1, 3], float)
print(a)
print(b)
print(a+b)

a = np.zeros((2,2), float)
b = np.array([-1., 3.], float)
print(a)
print(b)
print(a+b)
print(a + b[np.newaxis,:])
print(a + b[:,np.newaxis])

a = np.array([1, 4, 9], float)
print(np.sqrt(a))

a = np.array([1.1, 1.5, 1.9], float)
print(np.floor(a))
print(np.ceil(a))
print(np.rint(a))

print(np.pi)
print(np.e)

a = np.array([1, 4, 5], int)
for x in a:
    print (x)

a = np.array([[1, 2], [3, 4], [5, 6]], float)
for x in a:
    print (x)

a = np.array([[1, 2], [3, 4], [5, 6]], float)
for x,y in a:
    print (x*y)

a = np.array([2, 4, 3], float)
print(a.sum())
print(a.prod())
print(np.sum(a))
print(np.prod(a))

a = np.array([2, 1, 9], float)
print(a.mean())
print(a.var())
print(a.std())

a = np.array([2, 1, 9], float)
print(a.min())
print(a.max())

a = np.array([2, 1, 9], float)
print(a.argmin())
print(a.argmax())

a = np.array([[0, 2], [3, -1], [3, 5]], float)
print(a.mean(axis=0))
print(a.mean(axis=1))
print(a.min(axis=1))
print(a.max(axis=0))

a = np.array([6, 2, 5, -1, 0], float)
print(sorted(a))
a.sort()
print(a)

a = np.array([6, 2, 5, -1, 0], float)
print(a.clip(0, 5))

a = np.array([1, 1, 4, 5, 5, 5, 7], float)
print(np.unique(a))

a = np.array([[1, 2], [3, 4]], float)
print(a.diagonal())

a = np.array([1, 3, 0], float)
b = np.array([0, 3, 2], float)
print(a>b)