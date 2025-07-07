import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 114. Flatten Binary Tree to Linked List
 * Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */

//------------------------------------ Solution 1 -----------------------------------
public class FlattenTreeToLinkedList {
    /**
     * Optimized in-place solution: iterate over tree in post order level with process right child before
     * left child. Keep track of previous node and attach is to current node's right and nullify current node's
     * left. Update previous node to current before moving completing current recursion. This will ensure that
     * using only singly linked list we will be able to produce entire result and more importantly we are nullifying
     * the current node's left which is already processed in the post order manner before in the previous recursive calls
     *
     * TC: O(n) traversing all nodes in binary tree
     * Auxiliary SC: O(1) no extra space utilized
     * Recursive stack SC: O(h) h -> height of tree wrost case n for skewed tree. logn for perfect binary tree
     */
    TreeNode prev;
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        //base
        if (root == null) {
            return;
        }

        //logic
        dfs(root.right);
        dfs(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}


//------------------------------------ Solution 2 -----------------------------------
class FlattenTreeToLinkedList2 {
    /**
     * Unoptimized solution: We first traverse the given binary tree in pre-order manner and prepare
     * an arraylist of TreeNodes in pre-order manner. We have to do it this way since we do not want to
     * nullify the left child on the go and update right child while entire right subtree of current node
     * is unprocessed
     * Later traverse the list and update each element's left to null and right to next element in the list
     *
     * TC: O(n) traversing all nodes in binary tree and in the arraylist
     * Auxiliary SC: O(n) arraylist size
     * Recursive stack SC: O(h) h -> height of tree wrost case n for skewed tree. logn for perfect binary tree
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);

        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).left = null;
            list.get(i - 1).right = list.get(i);
        }
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        //base
        if (root == null) {
            return;
        }

        //logic
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
