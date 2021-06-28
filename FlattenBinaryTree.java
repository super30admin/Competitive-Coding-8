package CompetitiveCoding8;

/*S30 FAANG Problem #108 {Medium} - https://www.youtube.com/watch?v=vRARbQsqauY&list=PLWtKyKogBpBDSDsgA3mcSlstDoKPNGSx0&index=18&t=19s

Provided a binary tree, write a function that can flatten it to a linked list.

For example:
   1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
Source Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
-------------------------------------------------------------------------------------------------------
Time complexity : O(n)
space complexity: O(n)
Approach: First get the right node of BT and assign it to bottom right most node of the left node tree. then assign left node to right node of the root.Then left node becomes null
 Iterate the same step for right node. 

    1                   1               1                1           1
   / \                 /                 \                \           \ 
  2   5     ---->     2        --->       2        --->    2           2    
 / \   \             / \                 / \              /             \  
3   4   6           3   4               3   4            3               3 
                         \                   \            \               \
                          5                   5            4               4   
                           \                   \            \               \
                            6                   6            5               5
                                                              \               \
                                                               6    	       6
													   

Did this code run successfully in leetcode : yes
problems faces : no*/
    

public class FlattenBinaryTree {

    public void flattenIterative(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {

            if (node.left != null) {

                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            node = node.right;
        }

    }
    
    /*-------------------------------------------------------------------------------------------------------
    Time complexity :O(n)
    space complexity:O(n)
    Approach:
    Did this code run successfully in leetcode : yes
    problems faces : no*/
    public void flattenRecursive(TreeNode root) {

      //base case
        if (root == null || (root.left ==null && root.right==null)) {
            return;
        }
        
        //logic
        if(root.left!= null)
        {
            flattenRecursive(root.left);
            TreeNode tempright = root.right;
            root.right=root.left; 
            root.left = null;
            while(root.right != null)
            {
                root = root.right;
            }
            root.right = tempright;
        }
        flattenRecursive(root.right);
    }

}
