MAX_COINS = 101
MAX_CHANGE = 101


def count_coin_exchange(coins, num_diff, change):
    n = [[0 for _ in range(MAX_CHANGE)] for _ in range(MAX_COINS)]
    for i in range(1, num_diff + 1, 1):
        n[i][0] = 1
    for i in range(1, change + 1, 1):
        n[0][i] = 0
    for i in range(1, num_diff + 1, 1):
        for j in range(1, change + 1, 1):
            if j - coins[i - 1] < 0:
                num_comb = 0
            else:
                num_comb = n[i][j - coins[i - 1]]
            n[i][j] = n[i - 1][j] + num_comb

    return n[num_diff][change]


if __name__ == '__main__':
    coin_list = [1, 2, 3]
    print(count_coin_exchange(coin_list, len(coin_list), 4))
