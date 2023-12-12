import sys


def dijkstra(n, graph):
    nearest = [False for _ in range(0, n + 1)]
    distance = [sys.maxsize for _ in range(0, n + 1)]
    result = 0
    distance[1] = 0
    for _ in range(1, n + 1):
        _min = sys.maxsize
        for i in range(1, n + 1):
            if not nearest[i] and distance[i] < _min:
                _min = distance[i]
                vnear = i
        nearest[vnear] = True

        for i, w in graph[vnear]:
            if distance[vnear] + w < distance[i]:
                distance[i] = w
        result += _min
    return result


def main():
    total = int(input())
    for _ in range(total):
        n = int(input())
        graph = [[] for _ in range(n + 1)]

        for i in range(1, n + 1):
            node = list(map(int, input().split()))
            for j in range(2, len(node), 2):
                graph[i].append((node[j], node[j + 1]))
        print(dijkstra(n, graph))


if __name__ == "__main__":
    main()
