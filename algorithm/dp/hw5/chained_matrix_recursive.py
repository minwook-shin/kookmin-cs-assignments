import sys


def chained_matrix(a, i, num):
    minimum = sys.maxsize
    if i == num:
        return 0
    for k in range(i, num, 1):
        c = chained_matrix(a, i, k) + chained_matrix(a, k + 1, num) + a[i - 1] * a[k] * a[num]
        minimum = min(minimum, c)
    return minimum


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        arr = list(map(int, input().split()))
        num = arr.pop(0)
        result = chained_matrix(arr, 1, num)
        print(str(result))


if __name__ == "__main__":
    main()
