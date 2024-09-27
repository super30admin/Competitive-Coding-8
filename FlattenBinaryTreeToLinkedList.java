public class FlattenBinaryTreeToLinkedList {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	//TC - o(n)
    //SC - o(h) worst case o(n)
    public void flatten(TreeNode root) {
        
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        
        if(root.left != null){
            //if root.left is not null - flatten the left tree
            flatten(root.left);
            //store right tree to temp var
            TreeNode tempRight = root.right;
            //add flatten left tree to root.right
            root.right = root.left;
            //make left to null
            root.left = null;
            //traverse the added nodes till root.right is null
            while(root.right != null)
                root = root.right;
            //establish the connection with the right node of the tree
            root.right = tempRight;
        }
        //flatten right tree
        flatten(root.right);
        
    }

}
