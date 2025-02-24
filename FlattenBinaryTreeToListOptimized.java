//TC: O(n)
//sC: O(1)
//approach: reach rightmost node of left child, connect it to right child and then move left subtree to right and so on

public class FlattenBinaryTreeToListOptimized {
    public void flatten(TreeNode root) {
        if(null == root || (null == root.left && null == root.right)) return;
        TreeNode curr = root;
        while(null != curr){
            if(null != curr.left){
                TreeNode prev = curr.left;
                while(null != prev.right){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
