def find_team(arr, n):
    dp = [0 for _ in range(0, n + 1)]
    result = 0
    for i in range(1, n + 1):
        if dp[i] == 0:
            dp[i] = 1
            i -= 1
            j = arr[i]
            result += 1
            while dp[j] == 0:
                dp[j] = 1
                j -= 1
                j = arr[j]
    return result


def main():
    count = int(input())
    for _ in range(count):
        arr = list(map(int, input().split()))
        c = arr.pop(0)
        print(find_team(arr, c))


if __name__ == '__main__':
    main()
