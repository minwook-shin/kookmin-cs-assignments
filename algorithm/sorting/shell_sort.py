from math import floor


def shell_sort(a: list):
    n = len(a)
    shrink_ratio = 2
    gap = len(a) // shrink_ratio

    count = 0
    while gap > 0:
        for i in range(gap, n, 1):

            tmp = a[i]
            j = i
            while j >= gap:
                count += 1
                if a[j - gap] > tmp:
                    a[j] = a[j - gap]
                    j -= gap
                else:
                    break
            a[j] = tmp
        gap //= shrink_ratio
    print(count)
    return a


if __name__ == '__main__':
    result = shell_sort([8, 7, 6, 5, 4, 3, 2, 1])
    print(result)
