//time complexity- O(n)
//space complexity- O(h) where is the height of the tree
public class FlattenBinaryTreetoLinkedList {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    static TreeNode prev = null;
    static void flatten(TreeNode root) {
        postOrder(root);
    }
    static void postOrder(TreeNode node) {
        if(node != null) {
            postOrder(node.right);
            postOrder(node.left);
            node.left = null;
            node.right = prev;
            prev = node;
        }
    }

    static void printList(TreeNode node) {
        while(node != null) {
            System.out.print(node.val);
            if(node.right != null) System.out.print(" -> ");
            node = node.right;
        }
    }
    public static void main(String[] args) {
        /*
                1
               / \
              2   5
            / \    \
           3   4    6
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        printList(root);
    }
}
