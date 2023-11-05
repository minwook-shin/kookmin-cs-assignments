def maximum(a, b):
    return a if a > b else b


def max_sub_sequence_sum(a, start, end):
    if start == end:
        return a[start]
    else:
        mid = (start + end) // 2
        left = max_sub_sequence_sum(a, start, mid)
        right = max_sub_sequence_sum(a, mid + 1, end)

        left_sum = 0
        max_left = 0
        for i in range(mid, start - 1, -1):
            max_left += a[i]
            if max_left > left_sum:
                left_sum = max_left
        right_sum = 0
        max_right = 0
        for i in range(mid + 1, end + 1):
            max_right += a[i]
            if max_right > right_sum:
                right_sum = max_right
        cross = left_sum + right_sum
        result = maximum(maximum(left, right), cross)
        return result


def main():
    count = int(input())
    for _ in range(count):
        a = list(map(int, input().split()))
        n = a.pop(0)
        a = max_sub_sequence_sum(a, 0, n - 1)
        print(a)


if __name__ == '__main__':
    main()
