'''

Solution:
1.  To flatten a Binary Tree, use recursion on left subtree and right subtree separately
    and attach the links (left and right links) accordingly.
2.  In first approach, first flatten left subtree and traverse till you reach the end node
    and attach that end node's right to flattened right subtree.
3.  In second approach, while return from the flatten function itself, return the end node
    so that there is no need to traverse till the end node again and again.

Time Complexity:    O(n.h) first approach and O(n) second approach
Space Complexity:   O(h) for both the approaches
--where n is the number of nodes and h is the height of the Binary Tree.

--- Passed all testcases successfully on leetcode for both the solutions.
'''


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class FlattenBT_SubOptimal:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        #   base case
        if (root == None or (root.left == None and root.right == None)):
            return root
        
        #   flatten left subtree
        self.flatten(root.left)
        
        #   make right node as the flattened left subtree and make left as Null
        tempRight = root.right
        root.right = root.left
        root.left = None
        
        #   flatten right subtree
        self.flatten(tempRight)
        
        #   iterate until the end of flattened left subtree and attach right node to the end node.
        currentNode = root
        while (currentNode.right != None):
            currentNode = currentNode.right
        currentNode.right = tempRight
        
        #   return the main root node.
        return root


class FlattenBT_Optimal:
    
    def __helper(self, root: TreeNode) -> TreeNode:
        
        #   base case
        if ( root == None or (root.left == None and root.right == None) ):
            return root
        
        #   flatten left and right subtrees
        leftTail = self.__helper(root.left)
        rightTail = self.__helper(root.right)
        
        #   store left and right nodes
        leftNode = root.left
        rightNode = root.right
        
        #   if flattened left subtree exists, then attach right node to left end node.
        if (leftTail != None):
            leftTail.right = rightNode
            root.right = leftNode        
        
        #   make left node Null
        root.left = None
        
        #   if flattened right subtree exists => return the last node of that,
        #   else return last node of flattened left subtree
        if (rightTail != None):
            return rightTail
        return leftTail
    
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        #   edge case
        if (root == None):
            return
        
        #   call the helper function on main root node
        self.__helper(root)