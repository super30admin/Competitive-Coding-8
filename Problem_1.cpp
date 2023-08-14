114. Flatten Binary Tree to Linked List

//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
public:
     void flatten(TreeNode* root) {
        auto now = root;

        while(now) {
            if(now -> left) {
                auto prev = now -> left;
                while(prev -> right) prev = prev -> right;
                prev -> right = now -> right;
                now -> right = now -> left;
                now -> left = nullptr;
            }
            now = now -> right;
        }
     }
};
