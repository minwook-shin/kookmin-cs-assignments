import copy
import sys


def bubble_sort(a, num):
    count_cmp_ops = 0
    count_swaps = 0
    for _pass in range(1, num, 1):
        for i in range(1, num - _pass + 1, 1):
            count_cmp_ops += 1
            if a[i - 1] > a[i]:
                count_swaps += 1
                a[i - 1], a[i] = a[i], a[i - 1]
    print(f"{count_cmp_ops} {count_swaps}", end=" ")


def bubble_sort_improved1(a, num):
    count_cmp_ops = 0
    count_swaps = 0
    for _pass in range(1, num, 1):
        swapped = False
        for i in range(1, num - _pass + 1, 1):
            count_cmp_ops += 1
            if a[i - 1] > a[i]:
                count_swaps += 1
                a[i - 1], a[i] = a[i], a[i - 1]
                swapped = True
        if not swapped:
            break
    print(f"{count_cmp_ops} {count_swaps}", end=" ")


def bubble_sort_improved2(a, num):
    count_cmp_ops = 0
    count_swaps = 0
    last_swapped_pos = num
    while last_swapped_pos > 0:
        swapped_pos = 0
        for i in range(1, last_swapped_pos, 1):
            count_cmp_ops += 1
            if a[i - 1] > a[i]:
                count_swaps += 1
                a[i - 1], a[i] = a[i], a[i - 1]
                swapped_pos = i
        last_swapped_pos = swapped_pos
    print(f"{count_cmp_ops} {count_swaps}")


def main():
    num_test_cases = int(sys.stdin.readline().rstrip())
    for _ in range(num_test_cases):
        b = list(map(int, sys.stdin.readline().rstrip().split()))
        num = b.pop(0)
        a = copy.deepcopy(b)
        bubble_sort(a, num)
        a = copy.deepcopy(b)
        bubble_sort_improved1(a, num)
        a = copy.deepcopy(b)
        bubble_sort_improved2(a, num)


if __name__ == "__main__":
    main()
