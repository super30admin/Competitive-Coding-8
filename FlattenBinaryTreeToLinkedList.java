public class FlattenBinaryTreeToLinkedList {
    TreeNode prev; //pointer that moves
    TreeNode head; //to store the main reference
    public void flatten(TreeNode root) { //O(n) T.C, O(n) S.C
        if(root == null) return;
        this.head = new TreeNode(-101); //dummy node
        this.prev = head; //assign head to prev as prev moves

        dfs(root); //recursion
        root.left = null; //as all left children are null
        root.right = head.right.right; //as head is a dummy node, head.right is the actual first node
    }

    private void dfs(TreeNode root) {
        //base
        if(root == null) return;

        //logic
        int currVal = root.val;
        TreeNode curr = new TreeNode(currVal); //temp node curr is built for each value, O(n) S.C

        prev.right = curr; //prev node's right is the new curr node
        prev.left = null; //explicitly assign its left to null
        prev = curr; //and move the prev to curr

        dfs(root.left); //preorder recursion
        dfs(root.right);
    }

    public void flattenMorris(TreeNode root) { //O(N) T.C, O(1) S.C
        if(root == null || root.left == null && root.right == null) return;

        if(root.left != null)
        {
            flattenMorris(root.left);

            TreeNode tempright = root.right;
            root.right = root.left;
            root.left = null;

            while(root.right != null) root = root.right;

            root.right = tempright;
        }
        flattenMorris(root.right);
    }

    public static void main(String[] args) {
        // Create the binary tree
        /*
                1
               / \
              2   5
             / \   \
            3   4   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        TreeNode root2 = root;

        // Flatten the binary tree to a linked list
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();
        solution.flatten(root);
        solution.flattenMorris(root2);

        // Print the flattened linked list
        printLinkedList(root);
        System.out.println(" ");
        printLinkedList(root2);
    }

    // Helper method to print the flattened linked list
    private static void printLinkedList(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}