def base_conversion(n, base):
    base_table = "0123456789abcdef"
    if n >= base:
        base_conversion(n//base, base)
    print(base_table[n % base])


if __name__ == '__main__':
    base_conversion(1234567, 16)
