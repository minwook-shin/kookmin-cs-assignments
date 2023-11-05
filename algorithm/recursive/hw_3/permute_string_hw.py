class Permute:
    def __init__(self, _str):
        self.count = 0
        self._str = _str

    def check_weight(self, _str):
        _str = list(self._str)
        result = 0
        for i in range(len(_str)):
            if i % 2 == 0:
                w = ord(_str[i]) - ord("a")
                result += w
            else:
                w = ord(_str[i]) - ord("a")
                result -= w
        return result

    def permute_string(self, begin = 0, end= None):
        if not end:
            end = len(self._str)
        self._str = list(self._str)
        _range = end - begin
        if _range == 1:
            w = self.check_weight("".join(self._str))
            if w > 0:
                self.count += 1
        else:
            for i in range(0, _range, 1):
                self._str[begin], self._str[begin + i] = self._str[begin + i], self._str[begin]
                self.permute_string(begin + 1, end)
                self._str[begin], self._str[begin + i] = self._str[begin + i], self._str[begin]


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        text = str(input())
        obj = Permute(text)
        obj.permute_string()
        print(obj.count)


if __name__ == "__main__":
    main()
    # print(check_weight("computer"))