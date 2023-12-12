def __find(p, i):
    if p[i] == i:
        return i
    return __find(p, p[i])


def __merge(p, r, x, y):
    r_x = __find(p, x)
    r_y = __find(p, y)
    if r[r_x] < r[r_y]:
        p[r_x] = r_y
    elif r[r_x] > r[r_y]:
        p[r_y] = r_x
    else:
        p[r_y] = r_x
        r[r_x] += 1


def kruskal(graph):
    result = []
    e, f = 0, 0
    graph = sorted(graph, key=lambda item: item[2])
    parent = []
    rank = []
    for node in range(n + 1):
        parent.append(node)
        rank.append(0)
    while f < n - 1:
        i, j, w = graph[e]
        e += 1
        p = __find(parent, i)
        q = __find(parent, j)
        if p != q:
            result.append([i, j, w])
            __merge(parent, rank, p, q)
            f += 1
    return result


if __name__ == '__main__':
    total = int(input())
    for _ in range(total):
        n = int(input())
        graph = []
        for i in range(n):
            d = list(map(int, input().split()))
            node = d[0]
            for j in range(d[1]):
                graph.append((node, d[2 + j * 2], d[3 + j * 2]))
        print(sum(weight for u, v, weight in kruskal(graph)))
