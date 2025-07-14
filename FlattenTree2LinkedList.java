//Time Complexity: O(n) Each node is visited exactly once, total operations = n, where n = number of nodes
//Space Complexity: O(h) (h = height of the tree)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


package practice.com;

public class FlattenTree2LinkedList {

    public static void main(String[] args) {
        TreeNode root = buildTree();

        System.out.println("Level Order Traversal:");
        flatten(root);
    }

    static TreeNode head;

    private static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);
        root.right = head;
        root.left = null;
        head = root;

    }

    // Constructing the same 12-node tree we discussed
    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        return root;
    }
}