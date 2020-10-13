//Time Complexity: O(n*depth) n = number of all nodes
//Space Complexity: O(depth)
//Did it run on leetcode: yes
/**Approach: I am traversing the tree in postorder traversal. In the recursion I make root.right = root.left and original root.left is stored in a temp node. Then I iterate root.right until it is null and add my temp at that point. Basically my program first does left subtree and right subtree then the root. **/

class Solution {
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left!=null){
            TreeNode temp;
            if(root.right!=null){
                temp = root.right;
            }
            else
                temp = null;
            root.right = root.left;
            root.left=null;
            while(root.right!=null){
                root = root.right;
            }
            root.right = temp;
            
        }
        
        
    }
    
}
