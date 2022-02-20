#Time Compelxity O(N)
#Space Complexity Height of tree O(H) 

class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        def flat(root):

            if root is None:
                return None
            leftEdge = flat(root.left)
            rightEdge = flat(root.right)

            if root.left:
                #leftEdge.right = root.right
                root.right = root.left
                root.left = None
                while leftEdge.right:
                    leftEdge = leftEdge.right
                leftEdge.right = rightEdge

            return root or leftEdge or rightEdge 
        flat(root)
