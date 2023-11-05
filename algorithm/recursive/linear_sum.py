def sum(a, n):
    if n == 1:
        return a[0]
    else:
        return sum(a, n - 1) + a[n - 1]


def main():
    a = [3, 6, 5, 2, 4]
    result = sum(a, 5)
    print(result)


if __name__ == '__main__':
    main()
