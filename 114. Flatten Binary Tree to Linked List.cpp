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
    /*
    Time: O(n)
    Space: O(n)

    Do pre-order traversal, keep track of previous node visited and current node being visited, make prev->right = curr
    but store the right of the current node in a variable first
    */

    TreeNode* prev = nullptr;
    void call(TreeNode* node){
        if(node == nullptr)  return;

        TreeNode* right = node->right; //store right node, because the right pointer can be modified
        
        if(prev != nullptr)  prev->right = node;
        prev = node;

        call(node->left);

        node->left = nullptr; //left subtree is traversed, so we can make left point to null

        call(right); //use the previously stored right pointer 
    }

    void flatten(TreeNode* root) {
        call(root);
    }
};
