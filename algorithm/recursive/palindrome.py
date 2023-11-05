def check_palindrome(_str: str, first, last):
    if last <= first:
        return True
    elif _str[first] != _str[last]:
        return False
    else:
        return check_palindrome(_str, first + 1, last - 1)


def main():
    line = "malayalam"
    result = check_palindrome(line, 0, len(line) - 1)
    print(result)


if __name__ == '__main__':
    main()