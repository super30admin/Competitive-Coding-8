class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def flatten(root: TreeNode) -> None:
    """
    Do not return anything, modify root in-place instead.
    """
    def flatten_tree(node: TreeNode) -> TreeNode:
        if not node:
            return None
        
        # Recursively flatten the left and right subtrees
        left_tail = flatten_tree(node.left)
        right_tail = flatten_tree(node.right)
        
        # If there's a left subtree, we need to insert it between the node and the right subtree
        if left_tail:
            left_tail.right = node.right
            node.right = node.left
            node.left = None
        
        # Return the rightmost node after flattening
        return right_tail or left_tail or node
    
    flatten_tree(root)

#O(n)-> time , where n is the number of nodes in the tree
#O(1)-> space