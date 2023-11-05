class FastFibo:
    def __init__(self):
        self.result = [[0, 0], [0, 0]]

    def multiply(self, a, b):
        self.result = [[0, 0], [0, 0]]
        for i in range(2):
            for j in range(2):
                for k in range(2):
                    self.result[i][j] += (a[i][k] * b[k][j]) % 1000

    def power(self, m, n):
        if n == 0:
            self.result = [[1, 0], [0, 1]]
        elif n % 2 == 1:
            self.power(m, (n - 1) // 2)
            self.multiply(self.result, self.result)
            self.multiply(m, self.result)
        else:
            self.power(m, n // 2)
            self.multiply(self.result, self.result)


def main():
    for _ in range(int(input())):
        fibo_object = FastFibo()
        fibo_object.power([[1, 1], [1, 0]], int(input()))
        print((fibo_object.result[0][1]) % 1000)


if __name__ == '__main__':
    main()
