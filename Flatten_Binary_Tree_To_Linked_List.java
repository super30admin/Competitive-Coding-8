

class Solution {
	//Approach: 1. Here I have recursively go through nodes, if its a leaf node i will just return, if not i will check for presence of the left subtree, and 
	//if there is one, I will move it to the right with the swapping and will assign the right node to a pointer - temp.
	//2. Hence before recursing on right, I have to attach the left to the right subtree, so i will iterate till left end and attach my right subtree to left end. 
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        helper(root);
    }
    private void helper(TreeNode root)
    {
        //base 
        if(root == null)
            return;
        //handling leaf node
        if(root.left == null && root.right == null)
            return;
        //action
        helper(root.left);
        if(root.left != null)
        {
            TreeNode temp = root.right;
            root.right = root.left;
            //root.right.right = temp;
            TreeNode curr = root.right, prev = null;
            while(curr != null)
            {
                prev = curr;
                curr = curr.right;
            }
            prev.right = temp;
            root.left = null;
        }
        helper(root.right);
    }
}
//Time Complexity : O(n) 
//Space Complexity : O(h) height of the tree for the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
class TreeNode 
{
	int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}