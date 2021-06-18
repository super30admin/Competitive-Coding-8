/* Approach: 
1. Since we want to modify the left child of every node and set it to null, it is better to traverse the tree in "right, left, node" manner.
2. When we reach the first right most element, its right is set to prev. Which is null in the beginning. 
3. Then the right most element (the last in the linked list), is the prev node. 
4. Then 5 comes out, we modify it's prev and so on 

Time complexity: O(N)
Space complexity: O(H)
*/
public class FlattenBinaryTreeRecursive {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        traverseAndModify(root);
    }
    
    private void traverseAndModify(TreeNode root)
    {
        if(root==null)
            return;
        traverseAndModify(root.right);
        traverseAndModify(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
