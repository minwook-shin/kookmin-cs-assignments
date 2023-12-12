def dfs(n, graph, visit, c):
    visit.add(n)
    c += 1
    for n in graph.get(n, []):
        if n not in visit:
            c = dfs(n, graph, visit, c)
    return c


def cc(graph):
    visit = set()
    components = []
    for n in graph.keys():
        if n not in visit:
            c = 0
            c = dfs(n, graph, visit, c)
            components.append(c)
            components.sort()
    return len(components), components


def get_input_node():
    n = int(input())
    g = {}
    for _ in range(n):
        a = list(map(int, input().split()))
        __n = a.pop(0)
        _ = a.pop(0)
        g[__n] = a
    return g


if __name__ == '__main__':
    test_case = int(input())
    for _ in range(test_case):
        result = cc(get_input_node())
        print(result[0], *result[1])
