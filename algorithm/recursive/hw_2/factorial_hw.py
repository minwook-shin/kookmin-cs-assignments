import sys

sys.setrecursionlimit(10 ** 9)


def f(n):
    if n <= 1:
        return 1
    else:
        result = int(n * f(n - 1))
        while result % 10 == 0:
            result = int(result / 10)
        return result % 10000


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        print(f((int(input()))) % 1000)


if __name__ == '__main__':
    main()
