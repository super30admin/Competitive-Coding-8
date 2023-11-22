// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class FlattenBTtoLL {
//    class Solution {
//        Queue<TreeNode> q;
//        public void flatten(TreeNode root) {
//            if(root == null)
//                return;
//
//            this.q= new LinkedList<>();
//            perOrder(root);
//
//
//            TreeNode curr = root;
//            while(!q.isEmpty()){
//                TreeNode popped = q.poll();
//                if(popped == curr){
//                    curr.left = null;
//                }
//                else{
//                    curr.right = popped;
//                    curr.left = null;
//                    curr = curr.right;
//                }
//            }
//        }
//
//        private void perOrder(TreeNode root){
//            if(root == null)
//                return;
//
//            q.add(root);
//            perOrder(root.left);
//            perOrder(root.right);
//        }
//    }
class Solution {
    public void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right ==null)
            return;

        if(root.left != null){
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right != null){
                root = root.right;
            }
            root.right = tempRight;
        }
        flatten(root.right);
    }
}
}
