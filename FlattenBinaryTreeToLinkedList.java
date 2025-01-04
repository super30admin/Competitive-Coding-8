import java.util.ArrayDeque;
import java.util.Deque;

// LC 114
public class FlattenBinaryTreeToLinkedList {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Observe the output.
     * <p>
     * PreOrder == Root L R
     * <p>
     * i.e., flatten the left subtree
     * and then flatten the right subtree
     * <p>
     * such that connect the root.right=root.left(flattened)
     * and set root.left=null;
     * <p>
     * also, hold the root.right in a temp variable
     * such that we will connect the flattened left sub tree's last node to this temp right.
     * <p>
     * and then flatten the temp right tree.
     * <p>
     * TC: O(n)
     * SC: O(h)
     *
     * @param root
     */
    public void flatten_brute(TreeNode root) {
        if (root == null) {
            return;
        }
        // flatten the left subtree
        flatten_brute(root.left);
        TreeNode right = root.right;
        // if root.left == null --> left sub tree is already flattened
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            TreeNode curr = root;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = right;
        }
        // flatten the right sub tree
        flatten_brute(right);
    }

    /**
     * TC: O(n)
     * SC: O(h)
     *
     * @param root
     */
    public void flatten_iterative(TreeNode root) {
        // edge case
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            // push right first
            if (curr.right != null) {
                stack.push(curr.right);
            }
            // then push left, such that top can be easily connected to curr.right
            if (curr.left != null) {
                stack.push(curr.left);
            }
            curr.right = stack.peek();
            curr.left = null;
        }
    }

    /**
     * Morris PreOrder Traversal == Threaded Model of Binary Trees
     * TC: O(n)
     * SC: O(1)
     * <p>
     * PreOrder == Root L R
     * <p>
     * Create threads from Right most node of the Left subtree to Root's Right
     * <p>
     * Change Root's Right == Root's Left
     * Root's Left = null
     *
     * @param root
     */
    public void flatten_morris(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            TreeNode left = curr.left;
            if (left != null) {
                TreeNode right = left;
                while (right.right != null) {
                    right = right.right;
                }
//                if (right.right == null) {
                right.right = curr.right;
                curr.right = left;
                curr.left = null;
                curr = left;
//                }
            } else {
                curr = curr.right;
            }
        }
    }
}
