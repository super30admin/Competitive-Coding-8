//Time Complexity: O(n)
//Space Complexity: O(h)
//Code run successfully on LeetCode.

public class Problem1_2 {

    public void flatten(TreeNode root){
        
        if(root == null || root.left == null && root.right == null)
            return;
           
        if(root.left != null){
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null)
                root = root.right;
            root.right = temp;
        }
           
        flatten(root.right);
       }
}
