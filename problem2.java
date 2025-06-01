import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

//Time Complexity: O(n)
//Space Complexity: O(n)
public class problem2 {
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
    public void flatten(TreeNode root) {
      if (root == null) return;
        Stack<TreeNode> st= new Stack<>();
      while (root!= null) {
         TreeNode curr= st.pop();
         if(curr.right!=null)
         {
             st.push(curr.right);
         }
         if(curr.left!=null)
         {
             st.push(curr.left);
         }
         if(!st.isEmpty())
         {
             curr.right=st.peek();
         }
         curr.left=null;
         return;
      }
    }

}
