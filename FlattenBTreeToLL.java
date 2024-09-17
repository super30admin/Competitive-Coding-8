/**
The algorithm for this solution first traverses through the left children of the root, makes them 
them right children, and then adds the old right children to the last node of the new right children,
and repeats the process.

Did this code run on leetcode: Yes
 */
class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void flatten(TreeNode root) {
        
        if(root == null)
            return;
        
        if(root.left != null)
        {   //Traverse through left child
            flatten(root.left);
            //Store the current right node into a temporary node
            TreeNode dummy = root.right;
            //Make the left child the right child, and the left child null
            root.right = root.left;
            root.left = null;
            //Traverse the new right child till the final node
            while(root.right != null)
                root = root.right;
            //Point the final node of the new right child to the old right child of the root
            root.right = dummy;
        }
        //Repeat the process for the old right child
        flatten(root.right);
    }
}