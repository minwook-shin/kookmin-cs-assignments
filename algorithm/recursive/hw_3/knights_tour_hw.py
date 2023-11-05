MAX_SIZE = 9
MARK = 1
UN_MARK = 0

board = [[0 for i in range(MAX_SIZE)] for j in range(MAX_SIZE)]
path = [[0 for k in range(MAX_SIZE)] for l in range(MAX_SIZE)]


class Point:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y


direction = [Point(1, -2), Point(2, -1), Point(2, 1), Point(1, 2),
             Point(-1, 2), Point(-2, 1), Point(-2, -1), Point(-1, -2)]


def knight_tour(m, n, pos: Point, counter):
    _next = Point()
    if counter == m * n:
        return 1
    for i in range(0, 8, 1):
        _next.x = pos.x + direction[i].x
        _next.y = pos.y + direction[i].y
        if ((0 < _next.x <= n) and (0 < _next.y <= m) and
                (board[_next.y][_next.x] != MARK)):
            board[_next.y][_next.x] = MARK
            path[_next.y][_next.x] = counter+1
            if knight_tour(m, n, _next, counter+ 1):
                return 1
            board[_next.y][_next.x] = UN_MARK
    return 0


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        m, n, s, t = map(int, input().split())
        start = Point()
        start.y = s
        start.x = t
        for i in range(1, m + 1, 1):
            for j in range(1, n + 1, 1):
                board[i][j] = UN_MARK
        board[start.y][start.x] = MARK
        path[start.y][start.x] = 1

        if knight_tour(m, n, start, 1):
            if path[m][n] > 0:
                print("1")
            else:
                print("0")

        for i in path:
            for j in i:
                if j:
                    print(j, end=" ")
            print("")


if __name__ == '__main__':
    main()