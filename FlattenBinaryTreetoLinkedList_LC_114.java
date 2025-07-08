/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity  - O(N)
Space Complexity - O(H)
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
public class FlattenBinaryTreetoLinkedList_LC_114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        dfs(root);
    }

    void dfs(TreeNode root) {
        //base case
        if (root == null) return;

        //logic
        dfs(root.left);
        dfs(root.right);

        TreeNode tmp = root.left;
        root.left = null;
        TreeNode rightNode = root.right; //right side
        root.right = tmp; // left side

        //Preserve present node
        TreeNode present = root;
        while(present.right != null) {
            present = present.right;
        }
        present.right = rightNode;

    }
}
