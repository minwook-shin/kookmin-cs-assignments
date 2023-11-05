def reverse_string(a, i, j):
    if i < j:
        a[i], a[j] = a[j], a[i]
        reverse_string(a, i + 1, j - 1)
    return "".join(a)


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        text = input()
        print(reverse_string(list(text), 0, len(text) - 1))


if __name__ == '__main__':
    main()
