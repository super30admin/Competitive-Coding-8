import java.util.Stack;

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :getting started

// Your code here along with comments explaining your approach
public class FlattenBinaryTreetoLinkedList {

    /**
     * Definition for a binary tree node.
     * */
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    /**
     *     1
     *   2    3
     * 1.right =2
     * 1.left = null
     * 2.right = 1(prev).right
     * 2.left =null
     *   1
     *     2
     *       3
     */

    class Solution {
        public void flatten(TreeNode root) {
            if(root == null) return; //edge case

            Stack<TreeNode> st = new Stack<>();

            st.push(root);//adding root to stack

            while(!st.isEmpty()){
                TreeNode currentNode = st.pop();
                if(currentNode.right != null){//push right side of tree on to stack first
                    st.push(currentNode.right);
                }

                if(currentNode.left != null){//push left side of tree on to stack
                    st.push(currentNode.left);
                }

                if(!st.isEmpty()){
                    currentNode.right = st.peek();
                }

                currentNode.left = null; //set all left nodes to null
            }

        }
    }
}
