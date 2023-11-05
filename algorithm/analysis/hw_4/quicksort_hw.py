import copy
import sys

sys.setrecursionlimit(10 ** 9)


class QuickSort:
    def __init__(self, a, n, trigger=""):
        self.compare_count = 0
        self.swap_count = 0
        if trigger == "hoare":
            self.hoare_quick_sort(a, 0, n - 1)
        if trigger == "lomuto":
            self.lomuto_quick_sort(a, 0, n - 1)

    def hoare_partition(self, a, low, high):
        pivot = a[low]
        i = low - 1
        j = high + 1

        while True:
            i += 1
            while a[i] < pivot:
                i += 1
                self.compare_count += 1
            self.compare_count += 1
            j -= 1
            while a[j] > pivot:
                j -= 1
                self.compare_count += 1
            self.compare_count += 1
            if i < j:
                a[i], a[j] = a[j], a[i]
                self.swap_count += 1
            else:
                return j

    def hoare_quick_sort(self, v, low, high):
        if high > low:
            pivot_pos = self.hoare_partition(v, low, high)
            self.hoare_quick_sort(v, low, pivot_pos)
            self.hoare_quick_sort(v, pivot_pos + 1, high)

    def lomuto_partition(self, a, low, high):
        pivot = a[low]
        j = low
        for i in range(low + 1, high + 1, 1):
            if a[i] < pivot:
                j += 1
                a[j], a[i] = a[i], a[j]
                self.swap_count += 1
            self.compare_count += 1
        pivot_pos = j
        a[pivot_pos], a[low] = a[low], a[pivot_pos]
        self.swap_count += 1
        return pivot_pos

    def lomuto_quick_sort(self, v, low, high):
        if high > low:
            pivot_pos = self.lomuto_partition(v, low, high)
            self.lomuto_quick_sort(v, low, pivot_pos - 1)
            self.lomuto_quick_sort(v, pivot_pos + 1, high)


def main():
    count = int(input())
    for _ in range(count):
        a = list(map(int, input().split()))
        n = a.pop(0)

        arr = copy.deepcopy(a)
        obj = QuickSort(arr, n, trigger="hoare")
        hoare_swap_count = obj.swap_count
        hoare_compare_count = obj.compare_count

        arr = copy.deepcopy(a)
        obj = QuickSort(arr, n, trigger="lomuto")
        lomuto_swap_count = obj.swap_count
        lomuto_compare_count = obj.compare_count
        print(hoare_swap_count, lomuto_swap_count, hoare_compare_count, lomuto_compare_count)


if __name__ == '__main__':
    main()
