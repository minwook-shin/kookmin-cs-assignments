def max_sub_sequence_sum(a, n, start, end):
    max_sum = 0
    for i in range(0, n, 1):
        for j in range(i, n, 1):
            this_sum = 0
            for k in range(i, j + 1, 1):
                this_sum += a[k]
                if this_sum > max_sum:
                    if a[i] == 0:
                        continue
                    max_sum = this_sum
                    start = i
                    end = j

    return max_sum, start, end


if __name__ == '__main__':
    a = [4, -6, 0, 2, 3, -4, 1, 3, 0, -9, 4, 1, -3, 2]
    n = 14
    # 구간의 최대합 5
    # 최대합  구간 [2, 4], [2, 7], [2, 8], [3, 4], [3, 7], [3,8], [10, 11]
    print(max_sub_sequence_sum(a, n, 0, len(a)))