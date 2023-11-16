import sys

G = [[0 for _ in range(100 + 1)] for _ in range(100 + 1)]


def chained_matrix(a, num):
    L = [[0 for _ in range(100 + 1)] for _ in range(100 + 1)]
    for n in range(num):
        for i in range(1, num - n + 1, 1):
            j = i + n
            if j == i:
                L[i][j] = 0
                continue
            L[i][j] = sys.maxsize
            for k in range(i, j):
                if L[i][j] > L[i][k] + L[k + 1][j] + a[i - 1] * a[k] * a[j]:
                    L[i][j] = L[i][k] + L[k + 1][j] + a[i - 1] * a[k] * a[j]
                    G[i][j] = k
    return L[1][num]


def print_order(i, j):
    if i == j:
        print("M" + str(i), end="")
    else:
        k = G[i][j]
        print("(", end="")
        print_order(i, k)
        print_order(k + 1, j)
        print(")", end="")


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        num = int(input())
        arr = list(map(int, input().split()))
        result = chained_matrix(arr, num)
        print_order(1, num)
        print("\n" + str(result))


if __name__ == "__main__":
    main()
