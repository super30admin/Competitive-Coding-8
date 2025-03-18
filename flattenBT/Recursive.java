package flattenBT;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Time Complexity (TC):
//O(N), since each node is visited once.
//Space Complexity (SC):
//O(H), where H is the height of the tree (recursion stack). In a balanced tree, H = logN; in a skewed tree, H = N.
//        Recursive DFS Traversal:
//If root is null, return null.
//Recursively process the left and right subtrees.
//Rearranging Nodes:
//If there is a left subtree (leftTail exists),
//Move the right subtree to leftTail.right.
//Move the left subtree to the right.
//Set root.left to null.
Returning the Last Node:

class Recursive {
    public void flatten(TreeNode root) {

        if(root==null || root.left==null && root.right==null)

            return;

        if(root.left!=null)

        {

            flatten(root.left);

            TreeNode tempright=root.right;

            root.right=root.left;

            root.left=null;

            while(root.right!=null) root=root.right;

            root.right=tempright;

        }

        flatten(root.right);

    }
}