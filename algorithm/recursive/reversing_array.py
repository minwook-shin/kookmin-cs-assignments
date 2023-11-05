def reverse_array(a, i, j):
    if i < j:
        a[i], a[j] = a[j], a[i]
        reverse_array(a, i + 1, j - 1)
    return a


def main():
    a = [5, 7, 1, 3, 4, 9, 2, 0, 8, 6]
    result = reverse_array(a, 0, 9)
    print(result)


if __name__ == '__main__':
    main()
