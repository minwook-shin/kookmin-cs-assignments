import sys


def chained_matrix(a, i, num, mem):
    if i == num:
        return 0
    if mem[i][num] is not None:
        return mem[i][num]
    mem[i][num] = sys.maxsize
    for k in range(i, num):
        mem[i][num] = min(mem[i][num], chained_matrix(a, i, k, mem) +
                          chained_matrix(a, k + 1, num, mem) + a[i - 1] * a[k] * a[num])
    return mem[i][num]


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        num = int(input())
        arr = list(map(int, input().split()))
        mem = [[None for _ in range(num + 1)] for _ in range(num + 1)]
        result = chained_matrix(arr, 1, num, mem)
        print(str(result))


if __name__ == "__main__":
    main()
