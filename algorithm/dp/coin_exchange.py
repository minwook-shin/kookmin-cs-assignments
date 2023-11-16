def coin_exchange(coins, num_diff, change):
    coin_used = [0] * (change + 1)
    last_coin = [0] * (change + 1)

    for cents in range(1, change + 1, 1):
        min_coin = cents
        new_coin = 1
        for j in range(0, num_diff, 1):
            if coins[j] > cents:
                continue
            if coin_used[cents - coins[j]] + 1 < min_coin:
                min_coin = coin_used[cents - coins[j]] + 1
                new_coin = coins[j]
        coin_used[cents] = min_coin
        last_coin[cents] = new_coin
    reconstruct(change, last_coin)


def reconstruct(change, last_coin):
    if change > 0:
        reconstruct(change - last_coin[change], last_coin)
        print(last_coin[change])


if __name__ == '__main__':
    coin_list= [1, 5, 10, 21, 25]
    change_coin = 63
    diff = len(coin_list)
    coin_exchange(coin_list, diff, change_coin)