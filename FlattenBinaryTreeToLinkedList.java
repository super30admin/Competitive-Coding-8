//Time Complexity O(N)
//Space Complexity O(H) of flatten2 method and O(1) for flatten method 
//Leetcode tested

public class FlattenBinaryTreeToLinkedList {

    public void flatten2(TreeNode root) {
        if(root  == null) return;

        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;

        root.left = null;

        flatten(tempLeft);
        flatten(tempRight);

        root.right = tempLeft;


        TreeNode current = root;
        while(current.right!=null)
            current = current.right;
        current.right = tempRight;

    }


    public void flatten(TreeNode root) {
        if(root  == null) return;

        while(root!=null){
            if(root.left!=null){
                TreeNode left = root.left;
                TreeNode current = left;
                while(current.right!=null) current = current.right;
                current.right = root.right;

                root.left = null;
                root.right = left;

            }

            root = root.right;
        }

    }

}
