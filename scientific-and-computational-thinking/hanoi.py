n = int(input("enter disk number:"))


def hanoi(first_disk, second_disk, third_disk, num):
    if num > 0:
        hanoi(first_disk, third_disk, second_disk, num - 1)
        print(first_disk, "->", third_disk + ":", num)
        hanoi(second_disk, third_disk, first_disk, num - 1)


hanoi("A", "B", "C", n)
