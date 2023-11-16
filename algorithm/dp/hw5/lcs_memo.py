# LCS MEMOIZATION

def length_lcs(s, t, m, n, mem):
    if m == 0 or n == 0:
        return 0
    if mem[m - 1][n - 1] is not None:
        return mem[m - 1][n - 1]
    elif s[m - 1] == t[n - 1]:
        mem[m - 1][n - 1] = 1 + length_lcs(s, t, m - 1, n - 1, mem)
        return mem[m - 1][n - 1]
    else:
        mem[m - 1][n - 1] = max(length_lcs(s, t, m - 1, n, mem), length_lcs(s, t, m, n - 1, mem))
        return mem[m - 1][n - 1]


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        text = str(input())
        a, b = text.split(" ")
        mem = [[None for _ in range(len(b) + 1)] for _ in range(len(a) + 1)]
        print(length_lcs(a, b, len(a), len(b), mem))


if __name__ == "__main__":
    main()
