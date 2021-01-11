//Time O(n)
//Space O(1)

class Solution {
public:
    void flatten(TreeNode* root) {
        TreeNode* leftNode = NULL,*rightNode = NULL;
        
        while(root!=NULL){
            leftNode = NULL;rightNode = NULL;
            if(root->left!=NULL){
                leftNode = root->left;
                if(root->right!=NULL) rightNode = root->right;

                root->right = leftNode;
                root->left = NULL;
                while(leftNode->right) leftNode = leftNode->right;
                leftNode->right = rightNode;
            }
            root = root->right;
        }
    }
};