//Time Complexity-O(n)
//Space Complexity-O(h)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    
    TreeNode* flattening(TreeNode*&root)
    {
        if(root==NULL)
        {
            return NULL;
        }
        if(root->left==NULL && root->right==NULL)
        {
            return root;
        }
        TreeNode* left=flattening(root->left);
        TreeNode* right=flattening(root->right);
        if(left!=NULL)
        {
            left->right=root->right;
            root->right=root->left;
            root->left=NULL;
        }
        if(right!=NULL)
        {
            return right;
        }
        else
        {
            return left;
        }
        
    }
    void flatten(TreeNode* root) {
        TreeNode* a=flattening(root);
    }
};