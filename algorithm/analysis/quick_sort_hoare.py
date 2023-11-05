def partition(a, low, high):
    pivot = a[low]
    i = low - 1
    j = high + 1

    while True:
        i += 1
        while a[i] < pivot:
            i += 1
        j -= 1
        while a[j] > pivot:
            j -= 1
        if i < j:
            a[i], a[j] = a[j], a[i]
        else:
            return j


def quick_sort(v, low, high):
    if high > low:
        pivot_pos = partition(v, low, high)
        quick_sort(v, low, pivot_pos)
        quick_sort(v, pivot_pos + 1, high)


if __name__ == '__main__':
    v = [5, 6, 9, 4, 0, 2, 1, 7, 3, 8]
    quick_sort(v, 0, 9)
    print(v)
