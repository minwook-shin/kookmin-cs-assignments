def find_long(a, l):
    result = tmp = [a[0]]
    for i in range(1, l, 1):
        if a[i] >= a[i - 1]:
            tmp.append(a[i])
        else:
            if len(tmp) > len(result):
                result = tmp
            tmp = [a[i]]
    if len(tmp) > len(result):
        result = tmp
    return len(result)


def main():
    count = int(input())
    for _ in range(count):
        arr = list(map(int, input().split()))
        c = arr.pop(0)
        print(find_long(arr, c))


if __name__ == '__main__':
    main()
