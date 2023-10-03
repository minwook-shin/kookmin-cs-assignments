def bubble_sort(a: list):
    n = len(a)
    last_swapped_pos = n  # 마지막 교환 위치
    while last_swapped_pos > 0:
        swapped_pos = 0
        for i in range(1, last_swapped_pos, 1):
            if a[i - 1] > a[i]:
                a[i - 1], a[i] = a[i], a[i - 1]
                swapped_pos = i
        last_swapped_pos = swapped_pos
    return a


if __name__ == '__main__':
    result = bubble_sort([1, 5, 3, 2, 7, 8, 4])
    print(result)
