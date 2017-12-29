def prime(n):
    global i
    if n % i == 0 and n > i:
        return True
    if n > i:
        i += 1
        return prime(n)


p = int(input('숫자 입력 : '))
get = prime(p)
if get is True:
    print("소수가 아닙니다")
else:
    print("소수입니다")
