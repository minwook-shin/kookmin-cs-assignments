# Kadane
def max_sub_sequence_sum(a, n):
    max_sum = 0
    this_sum = 0
    start = -1
    end = -1
    i = 0
    for j in range(0, n, 1):
        this_sum += a[j]
        if this_sum > max_sum:
            max_sum = this_sum
            start = i
            end = j
        elif this_sum <= 0:
            i = j + 1
            this_sum = 0
    return max_sum, start, end


def main():
    count = int(input())
    for _ in range(count):
        a = list(map(int, input().split()))
        n = a.pop(0)
        a, b, c = max_sub_sequence_sum(a, n)
        print(a, b, c)


if __name__ == '__main__':
    main()
