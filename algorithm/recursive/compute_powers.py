def p(x, n):
    if n == 0:
        return 1
    else:
        return x * p(x, n-1)


def main():
    result = p(2, 3)
    print(result)


if __name__ == '__main__':
    main()
