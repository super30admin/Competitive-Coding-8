// Time Complexity : O(N) where N = number of nodes
// Space Complexity : O(N) where N = number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
	1. traverse in preoder and add the elemens to a list
	2. Now traverse the right side of the list until some elements ezist on the right side
	3. Now replace the element with the top most element in the queue
	4. Make left as null
	5. If a right element doesn't exist create it
	6. Recusrively go to the right side
*/


// Your code here along with comments explaining your approach
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
    Queue<Integer> linkedList = new LinkedList<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        addToLinkedList(root);
        changeBinaryTree(root);
    }
    
    
    public void addToLinkedList(TreeNode root) {
        linkedList.add(root.val);
        if(root.left!=null) addToLinkedList(root.left);
        if(root.right!=null) addToLinkedList(root.right);
    }
    
     public void changeBinaryTree(TreeNode root) {
        root.left = null;
        if(linkedList.size() > 0) {
            root.val = linkedList.poll();
            if(root.right != null) changeBinaryTree(root.right);
            else if(linkedList.size() > 0) {
                root.right = new TreeNode();
                changeBinaryTree(root.right);
            }
        }
     }
}
