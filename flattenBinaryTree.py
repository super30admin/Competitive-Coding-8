"""
For each node with left child, find its rightmost predecessor in left subtree
Connect that predecessor’s .right to the current node’s .right
Move left subtree to right, set .left = None, and continue to .right
"""
"""
Time Complexity - O(n) – each node visited at most twice
Space Complexity - O(1) – no recursion or stack
"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class flattenBinaryTree:
    def flatten(self, root: 'TreeNode') -> None:
        curr = root
        while curr:
            if curr.left:
                
                pre = curr.left
                while pre.right:
                    pre = pre.right
               
                pre.right = curr.right
               
                curr.right = curr.left
                curr.left = None
            
            curr = curr.right

def print_flattened(root):
    while root:
        print(root.val, end=",")
        root = root.right
    print("None")

if __name__ == "__main__":
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(6)

    obj = flattenBinaryTree()
    obj.flatten(root)
    print_flattened(root)  
