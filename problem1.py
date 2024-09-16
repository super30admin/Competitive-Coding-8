#Time , space O(n)
class Solution:
    
    prev=None
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
      
 #RLV reverse pre order       
        if not root:
            return None
        
        self.flatten(root.right)
        
        self.flatten(root.left)
        
        root.right=self.prev
        root.left=None
        self.prev=root
        
