count = 0


def fib(n):
    global count
    if n <= 1:
        count += 1
        print(n, "last call")
        return n
    else:
        count += 1
        print(n)
        return fib(n - 1) + fib(n - 2)


def main():
    result = fib(4)
    # print(count)
    # print(result)


if __name__ == '__main__':
    main()
