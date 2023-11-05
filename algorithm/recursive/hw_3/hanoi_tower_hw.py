def hanoi(num_disk, k, a, b, c):
    if num_disk <= 0 or k <= 0:
        return

    if num_disk == 1:
        if k == 1:
            print(a, c)
        elif k == 2:
            print(a, b)
        elif k == 3:
            print(b, a)
        else:
            print(b, c)
        return

    num_disk -= 1
    if k < (2 ** num_disk):
        return hanoi(num_disk, k, a, c, b)
    elif k == (2 ** num_disk):
        print(a, c)
        return
    else:
        k -= (2 ** num_disk)
        return hanoi(num_disk, k, b, a, c)


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        n, k = map(int, input().split())
        hanoi(n, k, 1, 2, 3)


if __name__ == "__main__":
    main()
