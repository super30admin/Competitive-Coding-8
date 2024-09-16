/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
/*
for iterative approach we see if left child exists then we assign right [pointer] as
this left child and push our actual right to the stack and also the the left pointer
if left is null then we take right child, here it is already poiting so we just push
right child to the stack to establish its connection, else if both children are null
then we pop the stack if it's not null then we asign it's right to our curr's right
and then again push it to stack since its connections are still to be made,

*/
    public void flatten(TreeNode root)
    {
        // //recursive
        // TreeNode prev = new TreeNode(-1);
        // if(root == null) return;
        // helper(root,prev);


        //iterative
        if(root == null) return;

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while(!st.isEmpty()){

            TreeNode curr = st.pop();

            if(curr.left != null){
                TreeNode temp = curr.right;

                curr.right = curr.left;
                if(temp != null)
                    st.push(temp);
                st.push(curr.left);
                curr.left = null;
            }
            else if(curr.right != null){
                curr.left = null;
                st.push(curr.right);
            }
            else{
                if(!st.isEmpty()){
                    TreeNode temp1 = st.pop();
                    curr.right = temp1;
                    if(temp1 != null) st.push(temp1);
                }
                else{
                    curr.right = null;
                }
            }

        }


    }
//     //recursive
/*
For recusrive approach we are using an extra node prev for appending it's right
to our curr pointer, only thing we need to check is to update this prev when passing
on to our left child is cause if the curr has a right child then our left child
needs to point to that right child

*/
    public TreeNode helper(TreeNode curr, TreeNode prev)
    {
        if(curr == null) return null;

        // go to the left child and prev would be it's prev or curr itself if it has
        // right child of it's own
        TreeNode leftNode = helper(curr.left, curr.right != null ? curr : prev);

        //right node will alwyas take whatever prev came along
        TreeNode rightNode = helper(curr.right, prev);

        curr.left = null;

        if(leftNode != null)
            curr.right = leftNode;
        else if(rightNode != null)
            curr.right = rightNode;
        else
            curr.right = prev.right;

        return curr;
    }
}
