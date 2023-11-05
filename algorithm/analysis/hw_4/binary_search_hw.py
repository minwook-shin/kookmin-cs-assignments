def binary_search(a, left, right, value):
    if left > right:
        return -1
    else:
        mid = int((left + right) / 2)
        if a[mid] == value:
            return mid
        elif a[mid] > value:
            return binary_search(a, left, mid - 1, value)
        else:
            return binary_search(a, mid + 1, right, value)


def main():
    count = int(input())
    for _ in range(count):
        n, k = map(int, input().split())
        a = list(map(int, input().split()))
        print(binary_search(a, 0, n-1, k))


if __name__ == '__main__':
    main()
