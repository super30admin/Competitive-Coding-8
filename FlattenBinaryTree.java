//Time Complexity : O(n)
//Space Complexity : O(H)
public class FlattenBinaryTree {	
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	/**Approach: Recursion**/
	public void flatten(TreeNode root) {
        preOrder(root);
    }
    private TreeNode preOrder(TreeNode root){
        //null
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;
        
        //logic
        TreeNode leftTail= preOrder(root.left);
        TreeNode rigthTail= preOrder(root.right);
        
        //Shuffle from left subtree to the right
        if(leftTail != null){
            leftTail.right= root.right;
            root.right= root.left;
            root.left=null;
        }
        
        return (rigthTail==null) ? leftTail : rigthTail;
    }
	
	
	// Driver code to test above
	public static void main (String[] args) {
		FlattenBinaryTree ob= new FlattenBinaryTree();
		TreeNode t1= new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
				
		ob.flatten(t1);	
		System.out.print("Flatten BT is: "+t1.val);
		while(t1.right!=null) {
			System.out.print("\t"+t1.right.val);
			t1=t1.right;
		}
	}	
}
