
// Time Complexity : O(n) where n is the number of nodes in the binary tree
// Space Complexity : O(h) where h is the height of the binary tree due to recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. We will use a recursive approach to flatten the binary tree. We will first flatten the left subtree and then the right subtree.
// 2. After flattening the left subtree, we will store the right subtree in a
   // temporary variable and then set the right child of the current node to the left child and set the left child to null.
   // 3. We will then traverse to the end of the new right subtree and attach the original right subtree to the end of it.
// 4. The time complexity of this algorithm is O(n) because we are visiting each node once. The space complexity is O(h) where h is the height of the binary tree due to the recursive stack space. In the worst case, the height of the binary tree can be equal to the number of nodes in the tree, which would result in a space complexity of O(n).
// We can solve this using morris traversal to achieve O(1) space complexity, but the recursive approach is more intuitive and easier to understand.

 // Definition for a binary tree node.
  public class FlattenbinarytreetoLL {
      int val;
      FlattenbinarytreetoLL left;
      FlattenbinarytreetoLL right;
 
      FlattenbinarytreetoLL() {}
 
      FlattenbinarytreetoLL(int val) {
          this.val = val;
      }
 
      FlattenbinarytreetoLL(int val, FlattenbinarytreetoLL left, FlattenbinarytreetoLL right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Solution {

    public void flatten(FlattenbinarytreetoLL root) {

        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        FlattenbinarytreetoLL temp = root.right;

        root.right = root.left;
        root.left = null;

        FlattenbinarytreetoLL curr = root;

        while (curr.right != null) {
            curr = curr.right;
        }

        curr.right = temp;
    }
}