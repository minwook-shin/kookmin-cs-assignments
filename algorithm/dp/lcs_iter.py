def length_lcs(s, t, m, n):
    L = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
    S = [[None for _ in range(n + 1)] for _ in range(m + 1)]

    for i in range(1, m + 1, 1):
        for j in range(1, n + 1, 1):
            if s[i - 1] == t[j - 1]:
                L[i][j] = L[i - 1][j - 1] + 1
                S[i][j] = 0
            else:
                L[i][j] = max(L[i][j - 1], L[i - 1][j])
                if L[i][j] == L[i][j - 1]:
                    S[i][j] = 1
                else:
                    S[i][j] = 2
    return L[m][n], S


def print_lcs(s, t, m, n, S):
    if m == 0 or n == 0:
        return
    if S[m][n] == 0:
        print_lcs(s, t, m - 1, n - 1, S)
        print(s[m - 1])
    elif S[m][n] == 1:
        print_lcs(s, t, m, n - 1, S)
    elif S[m][n] == 2:
        print_lcs(s, t, m - 1, n, S)


if __name__ == '__main__':
    result, S = length_lcs("hello", "hell", 5, 4)
    print(result)
    print(print_lcs("hello", "hell", 5, 4, S))
