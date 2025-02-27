import javax.swing.tree.TreeNode;

/**
 * Time Complexity: 
 * Space Complexity: 
 * Did this code successfully run on Leetcode: Yes/No
 * Any problem you faced while coding this: None

 * Approach:
 * Explain your approach here.
 */

public class FlattenBTToLL {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root);
    }

    private void postorder(TreeNode root) {
        if (root == null)
            return;
        
        postorder(root.left);
        postorder(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }

        curr.right = temp;
    }
    public static void main(String[] args) {
        // Your code here
    }
}