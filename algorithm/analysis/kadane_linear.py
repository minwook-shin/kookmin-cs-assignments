# Kadane's Algorithm
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


if __name__ == '__main__':
    a = [4, -6, 0, 2, 3, -4, 1, 3, 0, -9, 4, 1, -3, 2]
    n = 14
    # a = [-1, -1, -1, -1, 0]
    # n = 5
    # 구간의 최대합 5
    # 최대합  구간 [2, 4], [2, 7], [2, 8], [3, 4], [3, 7], [3,8], [10, 11]
    print(max_sub_sequence_sum(a, n))