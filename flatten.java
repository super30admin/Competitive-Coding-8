//Time complexity: O(N)
//Space complexity: O(h)

//follow up: space: O(h) -> O(1)
//currently, space is recursive stack, we need to eliminate that
//Instead of recursively calling method, we should switch order of tree in the same place
class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        
        while(root != null){
            //perform operations on left until we switch it with null
            if(root.left != null){
                
                //store left tree in variable then switch it to null
                TreeNode tempL = root.left;
                root.left = null;
                
                TreeNode curr = tempL;
                //traverse to the end of the right side
                while(curr.right != null){
                    curr = curr.right;
                }
                
                //attach bottom of left tree to the right of root
                curr.right = root.right;
                root.right = tempL;
            }
            
            //left is null so go to right and perform same operations
            root = root.right;   
        }
    }
}