MAX_SIZE = 30


def binomial_coefficient(n, k):
    b = [[0 for _ in range(MAX_SIZE)] for _ in range(MAX_SIZE)]
    for i in range(0, n + 1, 1):
        for j in range(0, min(i, k) + 1, 1):
            if j == 0 or j == i:
                b[i][j] = 1
            else:
                b[i][j] = b[i - 1][j - 1] + b[i - 1][j]
    return b[n][k]


if __name__ == '__main__':
    print(binomial_coefficient(20, 15))
