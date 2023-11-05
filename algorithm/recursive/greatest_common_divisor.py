def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def main():
    result = gcd(1071, 1029)
    print(result)


if __name__ == '__main__':
    main()
