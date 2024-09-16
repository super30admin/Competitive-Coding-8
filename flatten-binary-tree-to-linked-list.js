// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {
    if (!root) return;
    
    let cursor = root;
    while (cursor != null) {
        if (cursor.left) {
            let rightNode = cursor.left;
            while (rightNode.right != null) {
                rightNode = rightNode.right;
            }
            
            rightNode.right = cursor.right;
            cursor.right = cursor.left;
            cursor.left = null;
        }
        cursor = cursor.right;
    }
};
