//approach - Morris traversal
//Here, we check if root's left is not null!
//if not, we stand at root's left as cuur. and go to it's right most child. 
//once we reach there, we update the pointer - curr.right = root.right; root is the top node, while curr is the end node of 
//what we traversed the right most part at, so the last node we reach at is curr. 
//now, we change the root pointers
//root.right = root.left; and root.left = null! so there's nothing on the left side to travel, so 
//at last we update the right node as = root = root.right and do the same traversal. 
//tc - processing each nodes once, so O(N)
// sc - no extra space is used so, constant. 
class Solution{

    public void flattenBinaryTree(TreeNode root)
    {
        if(root == null) return;

        
        while(root != null)
        {
            TreeNode curr = root;
            if(curr.left != null)
            {
                curr = curr.left;
                //go to the right most position
                while(curr.right != null) curr = curr.right;
                
                //switching the pointers from the top!
                curr.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            //curr's left is null or we're done iterating through the right most part 
            root = root.right;
        }
    }
}



//approach- 2 - DFS based approach
//PRE ORDER TRAVERSAL
//we stand at the root and store it's left subtree in tempLeft node and riht in tempRight node. 
//root.left  = null.
//now, we recursively go and flatten the left subtree and same do for the right subtree. 
//once we are done flattening the left and then right tree, 
//first we have update root's right, so for next iteration we have right values there, and for that
//we will append the leftTree there. root.right = leftTree
//
//Now we have to update last standing nodes right to tempRight!!
//which goes like this - TreeNode curr = root;
//we'll traverse through the node until we find null
//while(curr.right != null) curr = curr.right; - so we are standing at the right most tree's last node!
//once we , then  curr.right = tempRight
//that's it. 
//at last we update the next root to be processed - root = root.right!- no we dont need it as  it's recursion  so it will return 
//to previous root. This was a mistake keeping it here for reference. 
//TC - O(N), processing all nodes
//sc - recusrive stack -O(h)

class Solution{

    public void flattenBinaryTree(TreeNode root)
    {
        if(root == null) return;

        TreeNode left_subtree = root.left;
        TreeNode right_subtree = root.right;
        root.left =null;

        flattenBinaryTree(left_subtree);
        flattenBinaryTree(right_subtree);

        //we are out of flattening so now switching
        root.right = left_subtree;
        TreeNode curr = root;

        while(curr.right != null) curr = curr.right;

        //standing at last point
        curr.right = right_subtree;

    }
}