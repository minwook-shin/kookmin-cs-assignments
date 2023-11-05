def f(n):
    if n <= 1:
        return 1
    else:
        return n * f(n - 1)


def main():
    result = f(5)
    print(result)


if __name__ == '__main__':
    main()
