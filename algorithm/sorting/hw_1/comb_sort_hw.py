def comb_sort(a, num):
    count_cmp_ops = 0
    count_swaps = 0
    gap = num
    shrink = 1.3
    _sorted = False
    while not _sorted:
        gap = int(gap / shrink)
        if gap <= 1:
            gap = 1
            _sorted = True
        i = 0
        while i + gap < num:
            if a[i] > a[i + gap]:
                a[i], a[i + gap] = a[i + gap], a[i]
                _sorted = False
                count_swaps += 1
            i += 1
            count_cmp_ops += 1
    print(count_cmp_ops, count_swaps)


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        a = list(map(int, input().split()))
        num = a.pop(0)
        comb_sort(a, num)


if __name__ == "__main__":
    main()
