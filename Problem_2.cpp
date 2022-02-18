/**
 * Time complexity:
 * O(n) where n is the number of nodes
 * 
 */

/**
 * Space complexity:
 * O(1) 
 * 
 */



/**
 * Iterative Approach (Morris Traversal);
 * We have to break down the problem in two parts that is left subtree and 
 * right subtree. We have to move the left subtree right of the parent node.
 * So the first thing that comes to mins is recursive solution. But it is 
 * not space optimized as it will be going to maintain a stack.
 * 
 * So, we have to think about restructuring the tree in such a way that 
 * we get our result.
 * Example :
 * Input:
 *        1
        /   \
       2     5
      / \     \
     3   4     6
 * Output:
    1
     \
      2
       \
        3
         \
          4
           \
            5
             \
              6

* To achieve this we have to move 3 and 4 before 5. So, we start from root and check
* it should not be null, then we move to the left child of root if it is not null
* and now the trickier part is that our intution says first go to 3 and then to 4.
* But we will go to 4 first and connect the right of 4 to the right of 1. Then we update
* the right of 1 with it's left which is 2. Till now we have achieved this.

     1
      \
       2
     /  \
    3    4
          \
           5
            \
            6

* So now we have to move our runner pointer to 2 and repeat the same process which 
* is check root and its left child exist or not. So here 3 exists and here there
* is no right child of 3, sow we directly connect it to the right of runner pointer
* which is 2 and updte 2's left as NULL.
 */

//The code ran perfectly on leetcode

class Solution {
public: 
    void flatten(Node* root) {
        Node *curr = root;
            while(curr != NULL){
                if(curr->left != NULL){
                    Node *store = curr->left;
                    while(store->right){
                        store = store->right;
                    }
                    store->right = curr->right;
                    curr->right = curr->left;
                    curr->left = NULL;
                }
                curr = curr->right;
            }
    }
};