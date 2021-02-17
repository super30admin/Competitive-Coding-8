# Approach 1: iterative solution with stack
# Comments in line
# Time - O(N)
# Space - O(H) where H is the height, but worst case if left skewed, ~= O(N)
    def flatten(self, root: TreeNode) -> None:
        
        if root == None:
            return
        
        stack = []
        
        # add the root to the stack
        stack.append(root)
        
        while stack:
            
            current = stack.pop()
            
            # to get the skewed tree on right we need to place the left node on the right of current node
            # add to stack right first then left, so we can process left first from stack
            # and assign to right of tree
            
            if current.right != None:
                stack.append(current.right)
                
            if current.left != None:
                stack.append(current.left)
                
            if stack != []:
                # if stack not empty, assign to right of current node the top value from stack -- this is the left node we pushed earlier
                current.right = stack[-1] # only need to peek the val        
            
            # set it to null, and repeat all steps until we don't have any node to process
            current.left = None
            


## Approach 2: Modify with pointer references
# optimized O(N) Time  
# space solution O(1)


    def flatten(self, root: TreeNode) -> None:

        # base case
        if root == None:
            return 
         
        current  = root
        
        while current:
            
            # if it has a left child
            if current.left:
                
                # update left child of current with right most node
                right_node = current.left # initial val is the current's left child
                while right_node.right:
                    right_node = right_node.right
                
                # re wire connections
                right_node.right = current.right 
                current.right = current.left 
                current.left = None 
                
               
            current = current.right