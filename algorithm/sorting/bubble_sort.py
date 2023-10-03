def bubble_sort(a: list):
    n = len(a)
    for _pass in range(1, n, 1):
        for i in range(1, n - _pass + 1, 1):
            if a[i - 1] > a[i]:
                a[i - 1], a[i] = a[i], a[i - 1]
    return a


if __name__ == '__main__':
    result = bubble_sort([1, 5, 3, 2, 7, 8, 4])
    print(result)
