def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)
def main():
    for _ in range(int(input())):
        v = input().split()
        print(gcd(int(v[0]), int(v[1])))
if __name__ == '__main__':
    main()
