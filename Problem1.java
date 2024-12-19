
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Problem1 {
    public void flatten(TreeNode root) {
        TreeNode leftShifted = flattenDfs(root);
    }

    //TC:O(N)
    //SC : O(H) --> worst cahe h becomes N
    public TreeNode flattenDfs(TreeNode root){
        //base condition
        if(root == null){
            return null;
        }

        TreeNode leftNode = flattenDfs(root.left);
        TreeNode rightNode = flattenDfs(root.right);


        if(leftNode != null){
            //we cut the rightNOde and attach it to leftNodes right
            //before we move the entire left to the right
            leftNode.right = root.right;
            // we move the entire left to the right
            root.right = root.left;
            //fiinally set the left node to null
            root.left = null;
        }
        if(rightNode != null){
            return rightNode;
        }else if(leftNode!= null){
            return leftNode;
        } else {
            return root;
        }


    }


}
