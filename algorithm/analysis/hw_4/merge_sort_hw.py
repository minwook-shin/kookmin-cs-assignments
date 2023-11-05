import copy

compare_count = 0


def merge(a, low, mid, high):
    global compare_count

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
        compare_count += 1
        k += 1
    while i <= mid:
        a[k] = tmp[i]
        k += 1
        i += 1
    while j <= high:
        a[k] = tmp[j]
        k += 1
        j += 1


def merge_sort(v, low, high):
    if low == high:
        return
    else:
        mid = (low + high) // 2
        merge_sort(v, low, mid)
        merge_sort(v, mid + 1, high)
        merge(v, low, mid, high)


def main():
    global compare_count

    count = int(input())
    for _ in range(count):
        a = list(map(int, input().split()))
        n = a.pop(0)
        merge_sort(a, 0, n - 1)
        print(compare_count)
        compare_count = 0


if __name__ == '__main__':
    main()
