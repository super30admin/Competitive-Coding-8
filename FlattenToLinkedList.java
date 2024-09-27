/**
 * Time Complexity : O(n) where n is the number of nodes
 * Space Complexity : O(n)
 */

public class FlattenToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){return;}
        dfs(root);
    }
    private void dfs(TreeNode root){
        if(root == null){return;}
        if(root.left != null){
        TreeNode temp = root.right;                                                             // temp pointer holding the right subtree always
        root.right = root.left;                                                             // The left side becomes the right side of the root
        root.left = null;                                                               // The left side is made null
        TreeNode curr = root;                                                                               // reach the leaf of the right subtree of the root formed till now
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = temp;                                                                          // Attach the temp to the recently added subtree to the right
        }
        dfs(root.right);                                                                        // Recursively is done for every node by traversing right side of the tree
    }
}

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