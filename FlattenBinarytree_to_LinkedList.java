TC: O(n)
SC: O(n)

Runtime: 1 ms, faster than 61.34% of Java online submissions for Flatten Binary Tree to Linked List.
Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.

Approach: We need preorder traversal. Use ArrayList to save the preorder. Then change left node to null and right node to the next
element in the List for every element in the list.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     List<TreeNode> list;
    public void flatten(TreeNode root) {
        if(root == null ) return ;
        list = new ArrayList<>();
        preorder(root);
        
         for (int i=0; i<list.size()-1; i++ ) {
             TreeNode temp = list.get(i);
             temp.left = null;
             temp.right = list.get(i+1);
            }
        list.get(list.size()-1).left = null;
        list.get(list.size()-1).right = null;
    }
    private void preorder(TreeNode root){
        if(root == null ) return ;
        list.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}
