n = 100
L = []
for i in range(2, n + 1):
    if i not in L:
        print(i)
        for j in range(i * i, n + 1, i):
            L.append(j)
