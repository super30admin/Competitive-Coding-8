package codes;

public class flattenBT_solution {
//	tc and sc O(n)(r-stack)
	  public void flatten(TreeNode root) {
	        helper(root);
	    }
	    
	    private  TreeNode helper(TreeNode root) {
	        
	        //
	        
	        // if null
	        if (root ==null){
	            return null;
	        }
	        
	        // if leave
	        if(root.left==null && root.right==null){
	            return root;
	        }
	        
	        TreeNode leftMost=helper(root.left);
	        TreeNode rightMost=helper(root.right);
	        
	        
	        if (leftMost!=null){
	            leftMost.right=root.right;
	            root.right=root.left;
	            root.left=null;
	        }
	        
	        
	        return rightMost==null ? leftMost:rightMost;
	    }
	    
}
