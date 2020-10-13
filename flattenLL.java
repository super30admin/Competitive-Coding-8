
public class flattenLL {

	public void BTLL(TreeNode root) {
		
		if(root == null)
			return;
		
		flatten(root, null);
	}
	
	public TreeNode flatten(TreeNode root, TreeNode prev) {
		
		if(root == null)
			return prev;
		// recurse through the right sub tree and assign values to the prev
		prev = flatten(root.right, prev);
		// recurse left subtree and assign values to the prev. So, this will attach, left subtree to prev which is holding right subtree
		prev = flatten(root.left, prev);
		// now prev will have left sub tree, assign root of right subtree to previous which is holding all the left and right subtree 
		root.right = prev;
		// we need make left subtree empty, so assign null
		root.left = null;
		// assign root to previous because this is the place where we will assign the values.
		prev = root;
		return prev;
	}
	
}
