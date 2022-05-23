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

public class FlattenBinaryTree {

    // TC: O(n) - number of nodes in a given tree
    // SC: O(1) - only two elements will be present in the stack at a given time
    public void flatten(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode prev = null,current = null;

        /*
            Preorder steps
            1. Get the element from top of the stack
            2. DO some processing
            3. Put right child into the stack
            4. Put left child into the stack
         */

        while(!stack.isEmpty()) {
            // 1. Get the element from top of the stack
            current = stack.pop();

            // 2. DO some processing here
            if(prev != null) {
                prev.right = current;
                prev.left = null;
            }

            // 3. Put right child into the stack
            if(current.right != null) stack.push(current.right);

            // 4. Put left child into the stack
            if(current.left != null) stack.push(current.left);

            prev = current;
        }

        //last one to be popped out, make it's right link null to end the linked list
        current.right = null;
    }
}
