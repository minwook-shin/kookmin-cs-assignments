def selection_sort(a: list):
    n = len(a)

    for i in range(0, n-1, 1):  # ppt j++ -> i++
        j_min = i

        for j in range(i + 1, n, 1):
            if a[j] < a[j_min]:
                j_min = j
        if j_min != i:
            a[j_min], a[i] = a[i], a[j_min]  # ppt 의사코드 j -> i
    return a


if __name__ == '__main__':
    result = selection_sort([1, 5, 3, 2, 7, 8, 4])
    print(result)
