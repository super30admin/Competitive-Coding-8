# Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No






class Solution {
    public void flatten(TreeNode root) {
      //base condition
        if(root == null) return;
        TreeNode curr= root;
        while(curr != null){
            //check left subtree-exists
            if(curr.left!=null){
                //Connect left subtree to the nodes right and set nodes left to null
                TreeNode temp= curr.right;
                curr.right= curr.left;
                curr.left = null;
                TreeNode p= curr.right;
                //Finally attach the previous right subtree, to the newly connected left-subtrees rightmost                     node
                while(p.right !=null) p= p.right;
                p.right = temp;
            }
            curr= curr.right;
        }
    }
}