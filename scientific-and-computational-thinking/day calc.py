import datetime


def get_date(add):
    t = ['월요일', '화요일', '수요일', '목요일', '금요일', '토', '일']
    before = "15-05-01"
    c_date = datetime.datetime.strptime(before, "%y-%m-%d")
    if add != 0:
        after = c_date + datetime.timedelta(days=add)
        print(after.strftime("%y-%m-%d"))
        r = after.weekday()
        print(t[r])
    else:
        after = c_date
        print(after.strftime("%y-%m-%d"))
        r = after.weekday()
        print(t[r])


n = int(input("enter plus days:"))
get_date(n)
