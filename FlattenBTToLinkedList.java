// Time Complexity : O(n), each node is visited
// Space Complexity : O(n), worst case linear skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use reverse pre-order traversal (current -> left -> right).
//   - Maintain a 'prev' pointer to link nodes like a linked list during traversal.
//   - At each step, set 'prev.left = null' and 'prev.right = current' to "flatten" the structure.
//   - Store 'curr.right' in a temp variable to avoid losing the subtree during recursion.
//   - Recursively process left and right subtrees.

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
public class FlattenBTToLinkedList {
    //TC = O(n) SC=O(n)
    TreeNode prev;
    public void flatten(TreeNode root) {
        this.prev = null;
        helper(root);
    }

    private void helper(TreeNode curr) {
        if(curr == null) {  //base case
            return;
        }

        if(prev != null) {  //handles making left null and making correct right tree
            prev.left = null;
            prev.right = curr;
        }

        TreeNode temp = curr.right;
        prev = curr;

        helper(curr.left);
        helper(temp);
    }

    public static void main(String[] args) {
        FlattenBTToLinkedList solution = new FlattenBTToLinkedList();

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6))
        );

        solution.flatten(root);

        //print the flattened linked list
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }
}
