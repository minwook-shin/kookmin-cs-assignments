def count_up(n_count):
    if n_count > 0:
        count_up(n_count - 1)
    print(n_count)


def count_down(n_count):
    print(n_count)
    if n_count > 0:
        count_down(n_count - 1)


if __name__ == '__main__':
    count_up(4)
    count_down(4)