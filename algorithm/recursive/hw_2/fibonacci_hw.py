def fib(n):
    return n if n <= 1 else fib(n - 1) + fib(n - 2)
def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        print(fib(int(input())))
if __name__ == '__main__':
    main()
