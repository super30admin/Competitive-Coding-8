//Time = O(n)
//Space = O(n)
//Leetcode ; yes
//Issue: none
class Solution {
public:
    void flatten(TreeNode* root) {
        stack<TreeNode*> st;

        if(!root) return;
        st.push(root);

        while(!st.empty()){

            TreeNode* node = st.top();
            st.pop();

            //push its children on stack
            if(node->right){
               st.push(node->right);
            }
            if(node->left){
               st.push(node->left);
            }
            // update the right link
            //cout << node->val << '\n';
            if(!st.empty()) {
              node->right = st.top();
            } else {
                node->right = NULL;
            }
            //update the left link
            node->left = NULL;
        }
    }
