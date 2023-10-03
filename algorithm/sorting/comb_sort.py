from math import floor


def comb_sort(input):
    gap = len(input)
    shrink = 1.3
    sorted = False

    while not sorted:
        gap = floor(gap/shrink)
        if gap <= 1:
            gap = 1
            sorted = True
        i = 0
        while i + gap < len(input):
            if input[i] > input[i + gap]:
                input[i], input[i + gap] = input[i + gap], input[i]
                sorted = False
            i += 1
    return input


if __name__ == '__main__':
    result = comb_sort([1, 5, 3, 2, 7, 8, 4])
    print(result)