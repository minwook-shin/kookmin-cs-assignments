class Node:
    def __init__(self, data=None):
        self.data = data
        self.left_sub_tree = None
        self.right_sub_tree = None


class BinaryTree:
    def __init__(self):
        self.root = None

    def insert(self, root: Node, data) -> Node:
        if root is None:
            return Node(data)
        if data < root.data:
            root.left_sub_tree = self.insert(root.left_sub_tree, data)
        else:
            root.right_sub_tree = self.insert(root.right_sub_tree, data)
        return root

    def destruct(self, root: Node) -> None:
        if root is None:
            return
        else:
            self.destruct(root.left_sub_tree)
            self.destruct(root.right_sub_tree)
            del root

    def in_order(self, root: Node) -> None:
        if root is None:
            return
        else:
            self.in_order(root.left_sub_tree)
            print(root.data, end=" ")
            self.in_order(root.right_sub_tree)

    def pre_order(self, root: Node) -> None:
        if root is None:
            return
        else:
            print(root.data, end=" ")
            self.pre_order(root.left_sub_tree)
            self.pre_order(root.right_sub_tree)

    def post_order(self, root: Node) -> None:
        if root is None:
            return
        else:
            self.post_order(root.left_sub_tree)
            self.post_order(root.right_sub_tree)
            print(root.data, end=" ")

    def size(self, root: Node) -> int:
        if root is None:
            return 0
        else:
            return self.size(root.left_sub_tree) + self.size(root.right_sub_tree) + 1

    def height(self, root: Node) -> int:
        if root is None:
            return -1
        else:
            return max(self.height(root.left_sub_tree), self.height(root.right_sub_tree)) + 1

    def mirror(self, root: Node) -> None:
        if root is None:
            return
        else:
            root.left_sub_tree, root.right_sub_tree = root.right_sub_tree, root.left_sub_tree
            self.mirror(root.left_sub_tree)
            self.mirror(root.right_sub_tree)

    def sum_of_weight(self, root: Node) -> int:
        if root is None:
            return 0
        else:
            return self.sum_of_weight(root.left_sub_tree) + self.sum_of_weight(root.right_sub_tree) + int(root.data)

    def max_path_weight(self, root: Node) -> int:
        if root is None:
            return 0
        else:
            left_weight = self.max_path_weight(root.left_sub_tree)
            right_weight = self.max_path_weight(root.right_sub_tree)
            if left_weight >= right_weight:
                result = left_weight + int(root.data)
            else:
                result = right_weight + int(root.data)
            return result


def main():
    num_test_cases = int(input())
    for _ in range(num_test_cases):
        a = list(map(int, input().split()))
        a.pop(0)
        obj = BinaryTree()
        for i in a:
            obj.root = obj.insert(obj.root, i)
        print(obj.size(obj.root))
        print(obj.height(obj.root))
        print(obj.sum_of_weight(obj.root))
        print(obj.max_path_weight(obj.root))
        obj.mirror(obj.root)
        obj.pre_order(obj.root)
        print("")
        obj.in_order(obj.root)
        print("")
        obj.post_order(obj.root)
        print("")
        obj.root = obj.destruct(obj.root)
        if obj.root is None:
            print("0")
        else:
            print("1")


if __name__ == "__main__":
    main()
