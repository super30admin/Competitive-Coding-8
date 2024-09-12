package CompetitiveCoding8;

public class FlattenBinaryTreeToLinkedList {
    /* Created by palak on 8/8/2021 */

    /**
     * Definition for a binary tree node.   */
    public class TreeNode {
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

    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode temp;
        if(root.left != null) {
            temp = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null) {
                root = root.right;
            }
            root.right = temp;
        }
    }

    public static void main(String[] args) {

    }
}
