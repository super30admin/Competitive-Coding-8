// Time Complexity: O(n) 
// Space Complexity: O(h) h is height of tree
// Iterative Morris traversal solution
public class FlattenBtLL {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        //start from root
        while(root != null)
        {
           TreeNode left = root.left;
            // left is not null
           if(left != null)
           {
               // go to the right most node
               TreeNode curr = left;
               while(curr.right != null)
               {
                   curr = curr.right;
               }
               // to the right most node attach roots right
               // Morris Traversal concept
               curr.right = root.right;
               
               // disconnect root with it's children
               root.left = null;
               root.right = null;
                
              // right of root attach left
               root.right = left;
           }
            // repeat all over for the next root 
            // since there is nothing of left move right
            root = root.right;
        }
    }
}


// Time Complexity: O(n) 
// Space Complexity: O(h) h is height of tree
// Recursive solution
public class FlattenBtLL {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        
        // copy left and right of current root
        TreeNode leftHalf = root.left;
        TreeNode rightHalf = root.right;
        
        // disconnect root.left
        root.left = null;
        
        // flatten the left half of the root
        flatten(leftHalf);
        // flatten the right half of the root
        flatten(rightHalf);
        
        // attach flattened left to root.right
        root.right = leftHalf;
        
        // find last node of flatten left half
        TreeNode curr = root;
        while(curr.right != null)
        {
            curr = curr.right;
        }
        
        // to the right side of last node attach right half
        curr.right = rightHalf;
    }
}