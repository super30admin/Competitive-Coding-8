/**
 * Intuition: Move all the right nodes to the (right of the left nodes- if there) and then shift the entire left node as the right of the node and make the left node as null
 * TIme: O(N) every node is visited twice
 * Space: O(1)
 *
 * Approach 2: can use recursion to flatten the bottom most nodes first and then move up...avoiding the visiting of the nodes twice but extra space ll be used
 */
class Solution {
    public void flatten(TreeNode root) {
        while(root != null){

            TreeNode nleft = root.left;
            if(nleft != null){
                while(nleft != null && nleft.right != null)
                    nleft = nleft.right;
                nleft.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }

    private TreeNode helper(TreeNode node){
        if(node == null) return node;
        TreeNode ntemp = node;

        TreeNode rtemp = node.right;

        node.right = helper(node.left);
        while(node.right != null){
            node = node.right;
        }
        node.right = helper(rtemp);

        ntemp.left = null;
        return ntemp;
    }
}