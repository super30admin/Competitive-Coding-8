// Time Complexity: O(n)
// Space Complexity: O(1) excluding recursive call stack
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. We will do a postorder traversal of the tree and keep track of the previous node in the tree.
//2. We will set the right child of the current node to the previous node and left child to nullptr.
//3. We will update the previous node to the current node and continue the traversal.



class Solution {
    TreeNode* temp = nullptr;
public:
    void flatten(TreeNode* root) {
        if(root == nullptr){return;}
        flatten(root -> right);
        flatten(root -> left);
        root -> right = temp;
        temp = root;
        root -> left = nullptr;

    }
};