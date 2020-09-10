class Solution(object):
    def flatten(self, root):
        if not root:
            return None
        
        node = root
        while node:
            if node.left:
                rightmost = node.left
                while rightmost.right:
                    rightmost = rightmost.right
                rightmost.right = node.right
                node.right = node.left
                node.left = None
            node = node.right
        
#Time-Complexity:O(N)
#Space-complexity:O(1)