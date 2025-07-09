# ----------------------------------------------------
# Intuition:
#
# The goal is to transform a binary tree into a linked list (in-place),
# following the preorder traversal order.
#
# 1.   Most Optimal Morris Traversal:
#    - If left child exists, find its rightmost node (predecessor).
#    - Point predecessor’s right to current node’s right child.
#    - Move left subtree to right, set left to None.
#    - Avoids recursion/stack; modifies tree during traversal.
#    → Time: O(n), Space: O(1)
#
# 2.   Optimal - Reversed Preorder Recursive:
#    - Traverse the tree in reverse preorder: right → left → root.
#    - At each step, point current node's right to previously visited node,
#      and nullify left pointer.
#    - Use a class variable `prev` to track last visited node.
#    → Time: O(n), Space: O(h) for recursion stack (h = height of tree)
#
# 3.   Iterative with Stack:
#    - Simulate preorder traversal using stack.
#    - Rewire pointers so that each node's right points to the next node in preorder.
#    - Set each node's left to None.
#    → Time: O(n), Space: O(n)
#
# 4.   Brute Force (Preorder list then rebuild):
#    - Store all nodes in a preorder list.
#    - Then iterate through list and rewire each node.
#    → Time: O(n), Space: O(n)
# ----------------------------------------------------

from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    # ----------------------------------------------------
    # Morris Traversal (In-place, O(1) space)
    # ----------------------------------------------------
    def flatten(self, root: Optional[TreeNode]) -> None:
        curr = root
        while curr:
            if curr.left:
                prev = curr.left
                while prev.right:
                    prev = prev.right
                prev.right = curr.right
                curr.right = curr.left
                curr.left = None
            curr = curr.right

    # ----------------------------------------------------
    # Reversed Preorder Recursive (Optimal)
    # ----------------------------------------------------
    # def flatten(self, root: Optional[TreeNode]) -> None:
        
    #     self.prev = None

    #     def dfs(node):
    #         if not node:
    #             return
    #         dfs(node.right)
    #         dfs(node.left)
    #         node.right = self.prev
    #         node.left = None
    #         self.prev = node

    #     dfs(root)

    # ----------------------------------------------------
    # 💬 Iterative using Stack (Preorder simulation)
    # ----------------------------------------------------
    # def flatten(self, root: Optional[TreeNode]) -> None:
    #     if not root:
    #         return
    #     stack = [root]
    #     while stack:
    #         node = stack.pop()
    #         if node.right:
    #             stack.append(node.right)
    #         if node.left:
    #             stack.append(node.left)
    #         if stack:
    #             node.right = stack[-1]
    #         node.left = None

    # ----------------------------------------------------
    # 💬 Brute Force (Use list and reconnect)
    # ----------------------------------------------------
    # def flatten(self, root: Optional[TreeNode]) -> None:
    #     if not root:
    #         return
    #     nodes = []
    #     def preorder(node):
    #         if node:
    #             nodes.append(node)
    #             preorder(node.left)
    #             preorder(node.right)
    #     preorder(root)
    #     for i in range(len(nodes) - 1):
    #         nodes[i].left = None
    #         nodes[i].right = nodes[i + 1]



# For main Testing:
def print_flattened(root):
    while root:
        print(root.val, end=" -> ")
        root = root.right
    print("None")

if __name__ == "__main__":
    # Build tree: [1,2,5,3,4,null,6]
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(6)

    Solution().flatten(root)
    print_flattened(root)  # Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> None
