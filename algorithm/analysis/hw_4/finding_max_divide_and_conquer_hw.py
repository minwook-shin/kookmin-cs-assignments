def maximum(a, b):
    return a if a > b else b


def recur_max(a, left, right):
    if left == right:
        return a[left]
    else:
        half = (left + right) // 2
        left_max = recur_max(a, left, half)
        right_max = recur_max(a, half + 1, right)
        return maximum(left_max, right_max)


def main():
    count = int(input())
    for _ in range(count):
        a = list(map(int, input().split()))
        n = a.pop(0)
        a = recur_max(a, 0, n - 1)
        print(a)


if __name__ == '__main__':
    main()
