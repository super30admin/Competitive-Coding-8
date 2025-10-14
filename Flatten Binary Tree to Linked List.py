# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
'''
Solution 1: Brute Force, do Pre-order, store the nodes in the list and update right pointer
    - Pre-Order Recursion : root->left->right Store the nodes in a list
    - Iterate over the list, Make node.right point to next node in the list. 
      At the same time, make the node.left point to Null pointer. 
Time Complexity: O(N) 
Space Complexity: O(N)
'''
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        root_list = []
        self.helper(root,root_list)

        for i in range(len(root_list)):
            root_list[i].left=None
            if i<len(root_list)-1:
                root_list[i].right = root_list[i+1]
            else:
                root_list[i].right = None

    def helper(self,node,root_list):
        # base
        if node==None:
            return

        # logic
        root_list.append(node)
        self.helper(node.left,root_list) # left
        self.helper(node.right,root_list) # right

'''
Solution 2: Post order traversal , keeping track of right subtree's head. 
    - Post-Order Traversal: Right->left->Root
    - We start skewing the right-subtree and store the head of skewed right
      subtree in a global temporary variable. 
    - This is bottom-up appraoch, point current node's right to temporary(which is 
      the head to skewed right sub-tree)
Time Complexity: O(N) 
Space Complexity: O(H), H = height of tree. Recursive stack space 
'''
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        self.temp = None
        self.helper(root) 
    
    def helper(self,node):
        # base
        if node==None:
            return 

        # logic
        self.helper(node.right) # right 
        self.helper(node.left) # left
        node.right = self.temp
        node.left = None
        self.temp = node