//Time Complexity: O(n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1_1 {

    List<Integer> result;
    public void flatten(TreeNode root) {
        
        if(root == null)
            return;
        
        result = new ArrayList<>();
        
        preorder(root);
        
        for(int i =1; i < result.size(); i++){
            
            root.left = null;
            int val = result.get(i);
            root.right = new TreeNode(val);
            root = root.right;
        }
        
    }
    
    private void preorder(TreeNode root){
        
        if(root == null)
            return;
        
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
