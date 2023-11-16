def fib(n):
    if memo[n] >= 0:
        return memo[n]
    if n <= 1:
        memo[n] = n
        return n
    memo[n] = fib(n-1) + fib(n-2)
    return memo[n]


if __name__ == '__main__':
    num = 100
    memo: list = []
    memo[:] = [-1 for _ in range(num + 1)]
    print(fib(num))