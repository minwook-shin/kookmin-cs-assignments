class Stack:
    def __init__(self):
        self.s = []

    def push(self, item):
        self.s.append(item)

    def pop(self):
        return self.s.pop()

    def is_empty(self):
        return not self.s


def cc(graph):
    visit = set()
    components = []

    for node in graph.keys():
        if node not in visit:
            c = 0
            stack = Stack()
            stack.push(node)
            while not stack.is_empty():
                current = stack.pop()
                if current not in visit:
                    visit.add(current)
                    c += 1
                    for i in graph[current]:
                        stack.push(i)
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
        graph = get_input_node()
        result = cc(graph)
        print(result[0], *result[1])
