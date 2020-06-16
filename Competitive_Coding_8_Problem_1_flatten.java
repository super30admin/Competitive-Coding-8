//Time Complexity : O(n) As we will be vising all the nodes
//Space Complexity : O(n) We'll be saving all the nodes into the list
//Runs successfully on leetcode
//No problem


//Here we will be traversing the list in postOrder manner and will be saving nodes to list
//After the traversal completes, we will be rearranging nodes

import java.util.ArrayList;
import java.util.List;

public class Competitive_Coding_8_Problem_1_flatten {
    List<TreeNode> list;
    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        if(root == null) return;
        PostOrder(root);
        for(int i = 1 ;i < list.size() ; i++)
        {
            root.left = null;
            root.right = list.get(i);
            root = root.right;
        }
    }
    public void PostOrder(TreeNode root)
    {
        if(root == null) return;
        list.add(root);
        PostOrder(root.left);
        PostOrder(root.right);
    }


    //Time Complexity : O(n) As we will be visiting each nodes
    //Space Complexity : O(h) height of the tree (Recursive stack)
    //Runs successfully on leetcode
    //No problem

    //Here we will be attaching left node of a tree as right node and below that re attaching the previous right node


    public void flatten2(TreeNode root) {
        if(root == null) return;
        flatten2(root.left);
        flatten2(root.right);
        TreeNode right = root.right;
        if(root.left != null)
        {
            root.right = root.left;
            root.left = null;
            while(root.right!=null)
            {
                root = root.right;
            }
            root.right = right;
        }
    }



}
