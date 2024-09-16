package competitiveCoding8;

public class FlattenBinaryTreeToLinkedList {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//Preorder
	//Time Complexity : O(n), where n is the number of elements in root
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public void flatten(TreeNode root) {
        // base
        if(root == null)
            return;
        
        // logic
        if(root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode curr = root;
            while(curr.right != null)
                curr = curr.right;
            curr.right = temp;
        }
        
        flatten(root.right);
    }
	
	//Inorder
	//Time Complexity : O(n), where n is the number of elements in root
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public void flatten1(TreeNode root) {
        // base
        if(root == null || (root.left == null && root.right == null))
            return;
        
        // logic
        flatten1(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode curr = root;
        while(curr.right != null)
            curr = curr.right;
        curr.right = temp;
        
        flatten1(root.right);
    }
}
