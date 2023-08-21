//time O(n)
//space O(n+h)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> path;
    void flatten(TreeNode* root) {
        Helper(root);

        

        
    
        for(int i=1;i<path.size();i++){
            TreeNode* p = new TreeNode(path[i]);
            root->right = p;
            root = root->right;
            

            
        }
        

        
    }

    void Helper(TreeNode* root){
        if(root == NULL){return;}

        path.push_back(root->val);
        Helper(root->left);
        root->left = NULL;
        Helper(root->right);

    }
};