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
    void flatten(TreeNode* root) {
        deque<TreeNode*> st; 
        st.push_back(root);

        while(!st.empty() && root != nullptr) {
            TreeNode* node = st.back(); 
            st.pop_back(); 
            if(node->right != nullptr) st.push_back(node->right);
            if(node->left != nullptr) st.push_back(node->left);
            node->left = nullptr; 
            if(!st.empty()) node->right = st.back(); 
            else node->right = nullptr; 
        }    
    }
};