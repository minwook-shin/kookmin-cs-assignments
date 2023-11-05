def find_i(i, s):
    if not (i >= 1 and s[i - 1] >= s[i]):
        return i
    else:
        return find_i(i - 1, s)


def find_j(i, j, s):
    if not (s[i - 1] >= s[j]):
        return j
    else:
        return find_j(i, j - 1, s)


def find_next_permutation(n, s):
    i = n - 1
    i = find_i(i, s)
    if i == 0:
        s.reverse()
        return s
    j = n - 1
    j = find_j(i, j, s)
    s[i - 1], s[j] = s[j], s[i - 1]
    s[i:] = reversed(s[i:])
    return s


def main():
    print(''.join(find_next_permutation(int(3), list("bca"))))


if __name__ == '__main__':
    main()
