class Solution {
    // time complexity: O(n)
    // space complexity: O(n)
    public void flatten(TreeNode root) {
        // check null tree
        if(root == null)
            return;
        // construct stack to store the treenodes
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
            // create list with in place method
            if(!stack.isEmpty()){
                cur.right = stack.peek();
            }
            // set left pointer as null
            cur.left = null;
        }
    }
}