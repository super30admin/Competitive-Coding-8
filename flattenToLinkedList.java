// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    TreeNode nw;
    List<Integer> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root==null) return;
        
        TreeNode node = root;
        pre(root);
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
  
        root.left=null;
        root.right=null;
        
        for(int i=1;i<list.size();i++)
        {root.left = null; root.right = new TreeNode(list.get(i)); root=root.right;}
    }
    
    private void pre(TreeNode root)
    {
        if(root==null) return;
        
        list.add(root.val);
        if(root.left!=null)pre(root.left);
        if(root.right!=null)pre(root.right);
    }
    

}