def binary_search(a, left, right, value):
    if left > right:
        return None
    else:
        mid = int((left + right) / 2)
        if a[mid] == value:
            return mid
        elif a[mid] > value:
            return binary_search(a, left, mid - 1, value)
        else:
            return binary_search(a, mid + 1, right, value)


if __name__ == '__main__':
    arr = [1, 3, 4, 7, 9, 11, 15]
    print(binary_search(arr, 0, len(arr), 11))