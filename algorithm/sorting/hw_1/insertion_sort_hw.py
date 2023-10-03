def insertion_sort(a, num):
    count_cmp_ops = 0
    count_swaps = 0
    for i in range(1, num, 1):
        tmp = a[i]
        j = i
        while j > 0:
            count_cmp_ops += 1
            if a[j - 1] > tmp:
                count_swaps += 1
                a[j] = a[j - 1]
                j -= 1
            else:
                break
        a[j] = tmp
    print(count_cmp_ops, count_swaps)


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        a = list(map(int, input().split()))
        num = a.pop(0)
        insertion_sort(a, num)


if __name__ == "__main__":
    main()
