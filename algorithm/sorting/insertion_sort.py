def insertion_sort(a: list):
    n = len(a)

    for i in range(1, n, 1):
        for j in range(i, 0, -1):
            if a[j-1] > a[j]:
                a[j-1], a[j] = a[j], a[j-1]
    return a


if __name__ == '__main__':
    result = insertion_sort([1, 5, 3, 2, 7, 8, 4])
    print(result)
