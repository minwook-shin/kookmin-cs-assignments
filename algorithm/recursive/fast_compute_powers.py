def p(x, n):
    if n == 0:
        return 1
    elif n % 2 == 1:
        return x * (p(x, (n - 1) / 2) * p(x, (n - 1) / 2))
    else:
        return p(x, n / 2) * p(x, n / 2)


def main():
    result = p(2, 3)
    print(result)


if __name__ == '__main__':
    main()
