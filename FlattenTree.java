import java.util.Stack;

class TreeNode {
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

class FlattenTree {
    // TC: O(n)
    // SC: O(n)
    // Approach: Proceed in a pre order manner and maintain a prev pointer;
    // make the connections
    public void flattenIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (prev != null) {
                prev.right = current;
                prev.left = null;
            }

            if (current.right != null) {
                stack.add(current.right);
            }

            if (current.left != null) {
                stack.add(current.left);
            }

            prev = current;
        }
    }

    // global variable for recursive solution
    TreeNode prev = null;

    // TC: O(n)
    // SC: O(h)
    // Approach: same as iterative solution by using a global prev variable
    public void flattenRecursively(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);

        TreeNode rightNode = root.right;
        if (prev != null) {
            prev.right = root;
            prev.left = null;
        }

        prev = root;
        flattenRecursively(root.left);
        flattenRecursively(rightNode);
    }
}
