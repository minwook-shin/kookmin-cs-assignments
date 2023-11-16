count_recursive_call = 0


def max_custom(a, b):
    return a if a > b else b


def min_custom(a, b):
    return a if a < b else b


def find_min_max(arr, low, high):
    global count_recursive_call
    count_recursive_call += 1
    # base case 1
    if low == high:
        return arr[low], arr[low]
    # base case 2
    elif low + 1 == high:
        return (arr[high], arr[low]) if arr[low] > arr[high] else (arr[low], arr[high])
    # recursive step
    else:
        mid = (low + high) // 2
        l_min, l_max = find_min_max(arr, low, mid)
        r_min, r_max = find_min_max(arr, mid + 1, high)
        return min_custom(l_min, r_min), max_custom(l_max, r_max)


def main():
    count = int(input())
    for _ in range(count):
        global count_recursive_call
        count_recursive_call = 0
        arr = list(map(int, input().split()))
        c = arr.pop(0)
        min_val, max_val = find_min_max(arr, 0, c - 1)
        print(max_val, min_val, count_recursive_call)


if __name__ == '__main__':
    main()
