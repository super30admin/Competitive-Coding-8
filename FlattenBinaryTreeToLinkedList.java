// Time Complexity : O(n)
	// Space Complexity : O(h)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No
import com.util.customlist.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        if(root == null) return;
		helper(root);
		return;
	}
	
	private void helper(TreeNode root){
		//base
		if(root == null || root.right == null && root.left == null) return;
		//logic
		if(root.left != null){
			helper(root.left);
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = null;
			while(root.right != null)
				root = root.right;
			root.right = temp;
		}
		helper(root.right);
	}
}
