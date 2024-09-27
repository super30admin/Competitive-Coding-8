//Time Complexity-O(n)
//Space Complexity-O(1)
//Did the code run on Leetcode? yes

class Solution {
public:
    void flatten(TreeNode* root) {
        TreeNode* cur = root;
        while(cur!=NULL) {
            if(cur->left!=NULL) {
                TreeNode* tmp = cur->left;
                while(tmp->right!=NULL) 
                {
                    tmp = tmp->right;
                }
                    tmp->right = cur->right;
                    cur->right = cur->left;
                    cur->left = nullptr;
            }
            cur = cur->right;
        }
    }
};