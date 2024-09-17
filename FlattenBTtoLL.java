
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

public class FlattenBTtoLL {
    
    // TC: O(n)
    // SC: O(n)
    /*  iterative approach 
     public void flatten(TreeNode root) {

                 if(root==null)
                     return;
                 Stack<TreeNode> stack=new Stack<>();
                 stack.push(root);
                
                 while(!stack.isEmpty()){
                     TreeNode current= stack.pop();
                    
                     if(current.right!=null)
                         stack.push(current.right);
                    
                     if(current.left!=null)
                         stack.push(current.left);
                    
                     if(!stack.isEmpty())
                         current.right=stack.peek();
                   
                     current.left=null;
                   
                 }
                
             }
        */


             // In-place approach 
             public void flatten(TreeNode root) {

                if (root == null) {
                    return;
                }
                
                TreeNode node = root;
                
                while (node != null) {
                    
                    if (node.left != null) {
                        
                        TreeNode rightmost = node.left;
                        while (rightmost.right != null) {
                            rightmost = rightmost.right;
                        }
                        
                        rightmost.right = node.right;
                        node.right = node.left;
                        node.left = null;
                    }
                    
                    node = node.right;
                }
            }

}
