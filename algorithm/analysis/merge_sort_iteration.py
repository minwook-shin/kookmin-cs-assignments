import copy


def merge(a, low, mid, high):
    tmp = copy.deepcopy(a)
    i = k = low
    j = mid + 1
    while i <= mid and j <= high:
        if tmp[i] <= tmp[j]:
            a[k] = tmp[i]
            i += 1
        else:
            a[k] = tmp[j]
            j += 1
        k += 1
    while i <= mid:
        a[k] = tmp[i]
        k += 1
        i += 1
    while j <= high:
        a[k] = tmp[j]
        k += 1
        j += 1


def merge_sort(v, n):
    size = 1
    while size < n:
        i = 0
        while i < n:
            low = i
            mid = low + size - 1
            high = min(i + 2 * size - 1, n-1)
            if mid >= n - 1:
                break
            merge(v, low, mid, high)
            i += 2 * size
        size *= 2


if __name__ == '__main__':
    a = [3, 2, 5, 4, 1]
    merge_sort(a, len(a))
    print(a)
