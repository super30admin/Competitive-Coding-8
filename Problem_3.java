// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        int val=0;
        boolean flag=true;
        while(!qu.isEmpty()){
            int size=qu.size();
            result.add(new ArrayList<>());
            for(int i=0;i<size;i++){
                TreeNode node=qu.remove();
                if(node.left!=null){
                    qu.add(node.left);
                }
                if(node.right!=null){
                    qu.add(node.right);
                }
                if(flag){
                    result.get(val).add(node.val);
                }else{
                    result.get(val).add(0,node.val);
                }
            }
            flag=!flag;
            val=val+1;
            
        }
        return result;
    }
}

