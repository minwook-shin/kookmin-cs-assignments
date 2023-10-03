def shell_sort(a, num):
    count_cmp_ops = 0
    count_swaps = 0
    shrink_ratio = 2
    gap = num // shrink_ratio
    while gap > 0:
        for i in range(gap, num, 1):
            tmp = a[i]
            j = i
            while j >= gap:
                count_cmp_ops += 1
                if a[j - gap] > tmp:
                    count_swaps += 1
                    a[j] = a[j - gap]
                    j -= gap
                else:
                    break
            a[j] = tmp
        gap //= shrink_ratio
    print(count_cmp_ops, count_swaps)


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        a = list(map(int, input().split()))
        num = a.pop(0)
        shell_sort(a, num)


if __name__ == "__main__":
    main()
