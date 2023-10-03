def insertion_sort(a: list):
    n = len(a)

    for i in range(1, n, 1):
        tmp = a[i]
        j = i
        while j > 0:
            if a[j-1]>tmp:
                a[j] = a[j-1]
                j -= 1
            else:
                break
        a[j] = tmp
    return a


if __name__ == '__main__':
    result = insertion_sort([1, 5, 3, 2, 7, 8, 4])
    print(result)
