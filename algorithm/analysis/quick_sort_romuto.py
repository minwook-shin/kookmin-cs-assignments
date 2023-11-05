def partition(a, low, high):
    pivot = a[low]
    j = low
    for i in range(low + 1, high + 1, 1):
        if a[i] < pivot:
            j += 1
            a[j], a[i] = a[i], a[j]
    pivot_pos = j
    a[pivot_pos], a[low] = a[low], a[pivot_pos]
    return pivot_pos


def quick_sort(v, low, high):
    if high > low:
        pivot_pos = partition(v, low, high)
        quick_sort(v, low, pivot_pos)
        quick_sort(v, pivot_pos + 1, high)


if __name__ == '__main__':
    v = [5, 6, 9, 4, 0, 2, 1, 7, 3, 8, 1]
    quick_sort(v, 0, 10)
    print(v)
