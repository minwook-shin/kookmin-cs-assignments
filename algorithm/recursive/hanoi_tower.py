def hanoi(n, a, b, c):
    if n > 0:
        hanoi(n - 1, a, c, b)
        print(a, c)
        hanoi(n - 1, b, a, c)


def hanoi_count(n):
    if n <= 1:
        return 1
    else:
        return 2 * hanoi_count(n - 1) + 1


if __name__ == '__main__':
    num_disk = 4
    print(num_disk)
    hanoi(num_disk, 1, 2, 3)
    # print(hanoi_count(num_disk))
