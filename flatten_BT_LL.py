"""
    Approach:
    - Perform a reverse postorder traversal: right -> left -> root (i.e., DFS from bottom up).
    - Use a class-level pointer `self.prev` to remember the previously processed node.
    - For each node:
        - Flatten right and left subtrees recursively.
        - Set root.right = self.prev
        - Set root.left = None
        - Move self.prev = root
    - This constructs the linked list in reverse preorder (root-left-right).

    Time Complexity: O(n), where n is the number of nodes.
    Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
    """
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.prev = None
        def dfs(root):
            if not root:
                return
            dfs(root.right)
            dfs(root.left)
            root.right = self.prev
            root.left = None
            self.prev = root
        dfs(root)

def build_tree():
    n1 = TreeNode(1)
    n2 = TreeNode(2)
    n3 = TreeNode(3)
    n4 = TreeNode(4)
    n5 = TreeNode(5)
    n6 = TreeNode(6)

    n1.left = n2; n1.right = n5
    n2.left = n3; n2.right = n4
    n5.right = n6

    return n1


def print_flattened(root):
    """
    Prints the flattened tree as a linked list (right pointers).
    Expected Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    """
    while root:
        print(root.val, end=" -> " if root.right else "\n")
        root = root.right


def main():
    root = build_tree()
    Solution().flatten(root)
    print("Flattened tree:")
    print_flattened(root)


if __name__ == "__main__":
    main()