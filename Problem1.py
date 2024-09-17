#Time Complexity: O(n) n being number of nodes in the tree

#Space Complexity: O(1) constant space for variables

#Approach: Using Morris Travel here to avoid delaying the connection of rightmpst child in left subtree to the right subtree. If a node does not have left child then there is no problem we keep traversing to the right children. If it does, we find the node in left subtree which does not have right child. Now the right subtree of our tree will become the right child of this node and this node will then become the new child of the node of which we are exploring the left subtree. Now the left child of this node will be set to null so all the nodes will eventually be rightified.

#Did it run on Leetcode:Yes


class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        while root:
            if root.left:
                rightmost=root.left
                while rightmost.right:
                    rightmost=rightmost.right
                rightmost.right=root.right
                root.right=root.left
                root.left=None
            root=root.right