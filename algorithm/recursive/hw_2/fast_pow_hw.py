def p(x, n):
    if n == 0:
        return 1
    elif n % 2 == 1:
        func = p(x, (n - 1) / 2)
        return int((x * (func * func)) % 1000)
    else:
        func = p(x, n / 2)
        return int((func * func) % 1000)


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        v = input().split()
        print(p(int(v[0]), int(v[1])))


if __name__ == '__main__':
    main()
