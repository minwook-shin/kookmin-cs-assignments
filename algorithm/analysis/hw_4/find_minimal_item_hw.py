import sys

sys.setrecursionlimit(10 ** 9)


def find_minimal_item(a, n, start=0, current=None, save=None):
    if save is None:
        save = []
    if current is None:
        current = []
    if start >= n:
        return save
    else:
        if not current or a[start] < current[0]:
            current = [a[start]]
            save.append(len(current))
        else:
            current.append(a[start])
            save.append(len(current))
        return find_minimal_item(a, n, start + 1, current, save)


def main():
    count = int(input())
    for _ in range(count):
        a = list(map(int, input().split()))
        n = a.pop(0)
        get_length = find_minimal_item(a, n)
        get_max = max(get_length)
        print(get_max)


if __name__ == '__main__':
    main()
