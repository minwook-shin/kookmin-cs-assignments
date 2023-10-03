def selection_sort(a, num):
    count_cmp_ops = 0
    count_swaps = 0
    for i in range(0, num - 1, 1):
        j_min = i
        for j in range(i + 1, num, 1):
            count_cmp_ops += 1
            if a[j] < a[j_min]:
                j_min = j
        if j_min != i:
            count_swaps += 1
            a[j_min], a[i] = a[i], a[j_min]
    print(count_cmp_ops, count_swaps)


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        a = list(map(int, input().split()))
        num = a.pop(0)
        selection_sort(a, num)


if __name__ == "__main__":
    main()
