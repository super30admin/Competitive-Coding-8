// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
// Time Complexity: O(n) where n is the number of the nodes
// Space Complexity: O(n) 

class Solution {
    public:
        vector<TreeNode*> res;
        void helper(TreeNode* root){
            //base
            if(root == NULL) return;
    
            //logic
            res.push_back(root);
            if(root->left) helper(root->left);
            if(root->right) helper(root->right);
    
        }
        void flatten(TreeNode* root) {
            helper(root); 
            TreeNode* temp = root;
            for(int i=1; i<res.size(); i++){
                temp->left = NULL;
                temp->right = res[i];
                temp = temp->right;
            }
        }
    };

// Morris Preorder Traversal
// Time Complexity: O(n) where n is the number of the nodes
// Space Complexity: O(1)

class Solution {
    public:
        void flatten(TreeNode* root) {
            TreeNode* curr = root;
            while(curr!=NULL){
                if(curr->left == NULL){
                    curr = curr->right;
                }
                else{
                    TreeNode* prev = curr->left;
                    while(prev->right && prev->right != curr){
                        prev = prev->right;
                    }
                    prev->right = curr->right;
                    curr->right=curr->left;
                    curr->left=NULL;
                    curr = curr->right;
                }
            }
            
        }
    };
