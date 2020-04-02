/*
In-Order Recursion based solution 
Time-> O(NLogN), N is # of nodes 
Space-> O(N), N is # of nodes
*/
class Solution {
    public void flatten(TreeNode root) {
        //base case 
        if(root == null) return ; 
        TreeNode rightPtr = root.right ;
        //recursive call
        flatten(root.left) ; 
        //logic
        root.right = root.left ; 
        root.left = null ; 
        while(root.right != null) root = root.right ; 
        root.right = rightPtr ; 
        //recursive case
        flatten(root.right) ; 
    }
}



/*
In-Order Recursion based solution 
Time-> O(N), N is # of nodes 
Space-> O(N), N is # of nodes
*/
class Solution {
    public void flatten(TreeNode root) {
        //this is used to point to the current obj 
        this.flattenTree(root) ; 
    }
    private TreeNode flattenTree(TreeNode root) {
        //base case
        if(root == null)
            return null ;
        if(root.left == null && root.right == null) 
            return root ; 
        TreeNode leftTail = flattenTree(root.left) ; 
        TreeNode rightTail = flattenTree(root.right) ; 
        if(leftTail != null) {
            leftTail.right = root.right ; 
            root.right = root.left ; 
            root.left = null ; 
        }
        return rightTail == null? leftTail: rightTail ; 
    }
}


/*
Iterative Solution 
Time -> O(N), N is # of nodes in tree
Why O(N), since for a while loop, it is clear to see we visit each node once. 
But to calculate rightMost, we visit each node at the worst once, that in   all makes it O(2N)
Space O(1)
Approach: 
We calculate the rightMost of the left subtree (if leftsubtree exists). 
Then, we set the rightMost's right to the right of the tree. 
This is done in order to smoothly/safely re-wire the current tree's right to its left subtree. 
The reason for using rightMost
if we look at the SUBtree (any), ITS rightMost (which is its left subtree's rightest node) will be the last element from left subtree to be added to the right of SUBtree itself. 
So for that reason, to preserve the right subtree of SUBtree, we point rightMost to the SUBtree's right. 
*/
class Solution {
    public void flatten(TreeNode root) {
        //edge case
        if(root == null) return ; 
        //for travsersing
        TreeNode current = root ; 
        while (current != null) {
            //if it has left child/left subtree
            if(current.left != null) {
                //processing rightMost
                TreeNode rightMost = current.left ; 
            //calculating rightMost
            while(rightMost.right != null) rightMost = rightMost.right ; 
            //setting rightMost'right to the right of the current tree
            // in order to safely re-wire current's right as current's left
            rightMost.right = current.right ; 
            //re-wiring left as right
            current.right = current.left ; 
            current.left = null ; 
        }
        //to traverse down the tree
        current = current.right ; 
    }
}
}