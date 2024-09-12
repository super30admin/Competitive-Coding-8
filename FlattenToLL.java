// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(1) in place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was assuming tree is oringinally structured even after changing the pointers.
/* Your code here along with comments explaining your approach: We can hold the right subtree in a temp pointer. We can place the left subtree to the
right side of the root. Then attach the temp pointer holding the branch to the recently added subtree right part. Recursively we need to do traverse 
the left side and put it on the right side. The temp pointer will hold the right subtree again while the left subtree is getting connected to the root.
The root will go to the right side and perform the above operation recursively. The left side of each of the nodes will be made null.
*/
class Solution {
    public void flatten(TreeNode root) {
        if(root == null){return;}
        dfs(root);
    }
    private void dfs(TreeNode root){
        if(root == null){return;}
        if(root.left != null){
        TreeNode temp = root.right;                                                             // temp pointer holding the right subtree always
        root.right = root.left;                                                             // The left side becomes the right side of the root
        root.left = null;                                                               // The left side is made null
        TreeNode curr = root;                                                                               // reach the leaf of the right subtree of the root formed till now
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = temp;                                                                          // Attach the temp to the recently added subtree to the right
        }
        dfs(root.right);                                                                        // Recursively is done for every node by traversing right side of the tree
    }
}