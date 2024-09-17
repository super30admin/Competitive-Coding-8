// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this 

class Solution {
private:
    stack<TreeNode*> nodeq;
    
    // Function 
    void pre_order_trav(TreeNode* root)
    {
        if(root == NULL)
            return;
        
        nodeq.push(root);
        
        pre_order_trav(root->left);
        
        pre_order_trav(root->right);
    }
    
public:
    void flatten(TreeNode* root) {
        
        // Do pre order traversal and insert the nodes in a Stack
        pre_order_trav(root);
        
        int flag = 0;
        TreeNode* next = NULL;
        
        // Pop the elements of stack and create the linked list
        // in reverse order
        while(!nodeq.empty())
        {
            TreeNode* curr = nodeq.top();
            nodeq.pop();
            
            curr->left = NULL;
            curr->right = next;
            
            next = curr;
        }
    }
};