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


if __name__ == '__main__':
    arr = [5, 3, 9, 2, 4, 8, 1, 6, 0, 7]
    print(recur_max(arr, 0, len(arr)-1))
