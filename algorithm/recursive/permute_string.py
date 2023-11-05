def permute_string(_str, begin, end):
    _str = list(_str)
    _range = end - begin
    if _range == 1 :
        print("".join(_str))
    else:
        for i in range(0, _range, 1):
            _str[begin], _str[begin + i] = _str[begin + i], _str[begin]
            permute_string(_str, begin + 1, end)
            _str[begin], _str[begin + i] = _str[begin + i], _str[begin]


def permute(_str):
    permute_string(_str, 0, len(_str))


if __name__ == '__main__':
    permute("ABC")
