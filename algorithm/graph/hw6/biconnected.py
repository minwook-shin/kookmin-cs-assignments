import copy
import sys


def dfs(node, p, dfs_num, back, r, a):
    children = 0
    visit[node] = True

    global dfn
    dfs_num[node] = dfn
    back[node] = dfn

    dfn += 1
    for nn in graph[node]:
        if not visit[nn]:
            children += 1
            p[nn] = node
            dfs(nn, p, dfs_num, back, r, a)
            back[node] = min(back[node], back[nn])
            if back[nn] >= dfs_num[node]:
                if (p[node] != -1) or (children > 1):
                    a.add(node)
                c = set()
                while stack and (stack[-1] != (node, nn)):
                    c.add(stack.pop()[0])
                if stack:
                    c.add(stack.pop()[0])
                r.append(c)
        elif nn != p[node]:
            back[node] = min(back[node], dfs_num[nn])
            if not visit[nn]:
                stack.append((node, nn))


def get_input_node():
    n = int(input())
    g = {}
    for _ in range(n):
        a = list(map(int, input().split()))
        __n = a.pop(0)
        _ = a.pop(0)
        g[__n] = a

    __visit = {i: False for i in range(1, n + 1)}
    __disc = {i: -1 for i in range(1, n + 1)}
    __parent = copy.deepcopy(__disc)
    __low = {i: sys.maxsize for i in range(1, n + 1)}
    return g, __visit, __disc, __parent, __low, n


def print_solve(r, p):
    print(len(r))
    print(len(p), end=" ")
    for point in sorted(p):
        print(point, end=" ")
    print()


if __name__ == '__main__':
    test_case = int(input())
    for _ in range(test_case):
        graph, visit, disc, parent, low, n = get_input_node()
        stack = []
        result = []
        points = set()
        dfn = 0
        for i in range(1, n + 1):
            if not visit[i]:
                dfs(i, parent, disc, low, result, points)
        print_solve(result, points)
