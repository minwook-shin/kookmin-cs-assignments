# LCS RECURSIVE

def length_lcs(s, t, m, n):
    if m == 0 or n == 0:
        return 0
    elif s[m - 1] == t[n - 1]:
        return length_lcs(s, t, m - 1, n - 1) + 1
    else:
        return max(length_lcs(s, t, m - 1, n), length_lcs(s, t, m, n - 1))


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        text = str(input())
        a, b = text.split(" ")
        print(length_lcs(a, b, len(a), len(b)))


if __name__ == "__main__":
    main()
