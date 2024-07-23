// time complexity:O(n)
// space complexity:O(h)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return;
        if (root.left != null) {
            flatten(root.left);
            TreeNode tempright = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null)
                root = root.right;
            root.right = tempright;
        }
        flatten(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        s.flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }
}
