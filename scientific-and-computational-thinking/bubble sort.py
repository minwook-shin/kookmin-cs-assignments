import random
import time


def bubble_sort(L):
    for i in range(len(L)-1):
        for j in range(len(L)-1):
            if L[j] > L[j+1]:
                temp = L[j+1]
                L[j+1] = L[j]
                L[j] = temp


List = [random.randint(1,100) for _ in range(100)]
ts = time.time()
bubble_sort(List)
ts = time.time() - ts
print(List)
print(ts)
