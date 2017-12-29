d = int(input("enter day:"))
while d >= 7:
    d %= 7
day = d

if day == 0:
    print("일요일")
elif day == 1:
    print("월요일")
elif day == 2:
    print("화요일")
elif day == 3:
    print("수요일")
elif day == 4:
    print("목요일")
elif day == 5:
    print("금요일")
elif day == 6:
    print("토요일")
else:
    print("wrong string!")

