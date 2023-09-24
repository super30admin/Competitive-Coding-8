using System;
namespace Algorithms
{
    public class FlattenBinaryTreenToLinkedList
    {
        /// Time Complexity : O(n)
        // Space Complexity :O(n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Referred Online
        public void Flatten(TreeNode root)
        {
            //base
            if (root == null) return;
            if (root.left == null && root.right == null) return;
            //logic
            if (root.left != null)
            {
                Flatten(root.left);
                TreeNode tempRight = root.right;
                root.right = root.left;
                root.left = null;
                while (root.right != null) root = root.right;
                root.right = tempRight;
            }
            Flatten(root.right);
        }
    }
}
