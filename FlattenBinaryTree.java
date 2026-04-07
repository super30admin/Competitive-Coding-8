/*
Time Complexity : O(N), N nodes
Space Complexity : O(h), recursion frames in stack
Approach :
At each node, we get flattened left subtree and right subtree. Then we make the link, move left child to right.
link thr rightmost child of left and the right subtree.
*/
public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        dfs(root);
    }

    TreeNode dfs(TreeNode root){
        if(root == null) return null;

        TreeNode leftChild = dfs(root.left);
        TreeNode rightChild = dfs(root.right);
        if(leftChild != null){
            root.right = leftChild;
            TreeNode temp = leftChild;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right =  rightChild;
            root.left = null;
        }

        return root;
    }


    public void flattenMorrisOrder(TreeNode root) {
        if(root == null) return;
        TreeNode curr = root;

        while(curr != null){
            TreeNode pre = curr.left;
            // find rightmost child of left subtree
            if(pre!=null){
                while(pre.right!= null){
                    pre = pre.right;
                }

                // link the left and right subtree
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            // do the same for right subtree
            curr = curr.right;
        }
    }
}
