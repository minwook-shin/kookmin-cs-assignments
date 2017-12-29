y = int(input("enter year:"))
m = int(input("enter month:"))
d = int(input("enter day:"))
n = 0
if y == 1:
    n = int(0)
else:
    n += d

for i in range(1, y):
    if y % 4 == 0 and ((y % 100 > 0) or (y % 400 == 0)):
        n += 366
    else:
        n += 365

for j in range(0, m+1):
    if y == 1:
        n += 0
    else:
        month = [int(31), int(28), int(31), int(30), int(31), int(30), int(31), int(31), int(30), int(31), int(30), int(31)]
        n += month[j]

print(n)
if (n % 7) == 0:
    print("월요일")
elif (n % 7) == 1:
    print("화요일")
elif (n % 7) == 2:
    print("수요일")
elif (n % 7) == 3:
    print("목요일")
elif (n % 7) == 4:
    print("금요일")
elif (n % 7) == 5:
    print("토요일")
elif (n % 7) == 6:
    print("일요일")
