

//TC : O(N)
//SC : O(N)
class Solution {
    List<Integer> list;
    int i;
    public void flatten(TreeNode root) {
        if(root == null)    return;
        list = new ArrayList<>();
        inorder(root);
        //List with inorder;
        list.remove(0);
        System.out.println(list);
        i = 0;
        root.left = null;
        build(root);
        
    }
    public void inorder(TreeNode root){
        if(root == null)    return;
        list.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }
    public void build(TreeNode root){
        while(i <= list.size() - 1){
            TreeNode curr = new TreeNode(list.get(i));
            root.right = curr;
            root = root.right;
            i++;
        }
    
    }
    
}