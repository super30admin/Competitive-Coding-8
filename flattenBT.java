
// Time Complexity : O(N), in worst case each node will be visited twice if all nodes have left child.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Couldn't solve in interview


// Your code here along with comments explaining your approach
//Have created a visualization in pdf file.

class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null) return;
        
        TreeNode node = root;
        
        while(node != null){
            
            //if node has a left child
            if(node.left != null){
                //find the rightmost node
                TreeNode rightmost = node.left;
                System.out.println("First rightmost node: " + rightmost.val);
                System.out.println("Node left is: " + node.right.val);
                while(rightmost.right != null){
                    rightmost = rightmost.right;
                    System.out.println("Inside while loop: " + rightmost.val);
                }
                
                //rewire the connections 
                rightmost.right = node.right;
                System.out.println("Rewire connection: " + rightmost.right.val + " left is: " + node.left.val);
                node.right = node.left;
                node.left = null;
            }
            //System.out.println("original node is: " + node.val);
            //mode to the right side of the tree
            node = node.right;
            //System.out.println("New right node is: " + node.val);
        }
    }
}
