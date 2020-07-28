// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes. Forget to make the left nil.


// Your code here along with comments explaining your approach
// Idea is to move all the left node into right side. First traverse left if left node available and keep traversing into
//	the right most node of the left node. make a connection between righmost node and current root node right. then move the 
//	root into right node. keep doing the same .

// Flatten Binary Tree to Linked List

class Solution {
    func flatten(_ node: TreeNode?) {
        var root = node
        while root != nil {
            if root?.left != nil {
                var temp = root?.left
                while temp?.right != nil {
                    temp = temp?.right
                }
                temp?.right = root?.right
                root?.right = root?.left
                root?.left = nil
            }
            root = root?.right
        }
    }
}