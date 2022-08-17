//Time Complexity: O(n)
//Space Complexity: O(h)
//Code run successfully on LeetCode.

public class Problem1_3 {

    public void flatten(TreeNode root){
        
        if(root == null)
            return;
        
        Stack<TreeNode> s = new Stack<>();
        
        while(!s.isEmpty() || root != null){
            
            while(root != null){
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            
            if(root.left != null){
                
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;
                while(root.right != null)
                    root = root.right;
                root.right = temp;
                
            }
            root = root.right;
        }
    }
}
