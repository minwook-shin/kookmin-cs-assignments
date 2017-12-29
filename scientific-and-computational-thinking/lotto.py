import random

j = 0
temp = []
while j <= 45:
    i = random.randint(1, 46)
    if i in temp:
        continue
    else:
        val = i
        temp.append(val)
        print(val, "/", end="")
    j += 1
