'''
114 Flatten Binary Tree to Linked List
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null. The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:
  _1
 /  \\
 2   5
/ \\   \\
3 4    6
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

Follow up: Can you flatten the tree in-place (with O(1) extra space)?

Solution:
1. Bottom-up recursion
The flattening of trees occurs at the leaf nodes first, and we keep going up the tree using post-order traversal as we flatten subtrees below.
Time: O(N), Space: O(H)

2. Top-down recursion
The flattening of trees occurs at the root node, and we keep going down the tree using preorder traversal (root->left->right) as we flatten subtrees above.
Example:
Original Tree
  _1
 /  \\
 2    5
/ \\  \\
3  4    6
preorder traversal: 1 2 3 4 5 6

Step 0: Let root = 1
Step 1: Fetch the preorder predecessor of root.right (5) which is 4.
        (Preorder predecessor of a root is the the right extreme node on root's subtree)
Step 2: Connect predecessor (4) to root.right (5) by doing predecessor.right = root.right.
Step 3: Move the entire left subtree of root to root.right. (root.right = root.left)

1_
  \\
   2
 / \\
 3  4
    \\
     5
     \\
      6
Step 4: Move root to root.right. Hence, root = 2.
Step 5: Repeat Step 1. predecessor = 3
Step 6: Connect 3 to 4.
Step 7: Move entire left subtree of 2 to 2.right.
  1
  \\
   2
   \\
    3
    \\
     4
     \\
      5
      \\
       6

https://youtu.be/sWf7k1x9XR4?t=944
Time: O(N), Space: O(1)
'''
from binary_tree import *
def flatten_BottomUp(root) -> None:
    def flatten(root):
        if not root:
            return None
        if not root.right and not root.left: # child node
            return root

        left = flatten(root.left) # left is a linked list of left subtree
        right = flatten(root.right) # right is a linked list of right subtree

        curr = left
        tail_left = curr # track the last node of left linked list
        while curr:
            tail_left = curr
            curr = curr.right

        if left: # left list exists
            root.right = left
            root.left = None
            tail_left.right = right
        else: # right list exists
            root.right = right
        return root

    if not root:
        return None
    flatten(root)

def flatten_TopDown(root) -> None:
        curr = root
        while curr:
            # Find the predecessor of root.right:
            # a) If the left subtree exists, predecessor = right most node left # subtree
            # b) If the left subtree doesn't exist, root itself is the predecessor.
            if curr.left:
                predecessor = curr.left
                while predecessor.right:
                    predecessor = predecessor.right
                # At this point, we have found the predecessor

                # place predecessor before root.right
                predecessor.right = curr.right

                # move left subtree to right
                curr.right = curr.left

                # set left subtree to None
                curr.left = None

            # Go to the next node on the right
            curr = curr.right

def run_flatten():
    tests = [([1,2,5,3,4,None,6],[1,2,3,4,5,6]),
             ([1,2,3,4,5,None,8,None,None,6,7,9],[1,2,4,5,6,7,3,8,9]),
    ]
    for test in tests:
        root, ans = test[0], test[1]
        for method in ['top-down', 'bottom-up']:
            tree=build_tree_level_order(root)
            print(f"\nOriginal Tree")
            tree.display()
            if method == "top-down":
                flatten_TopDown(tree)
            elif method == "bottom-up":
                flatten_BottomUp(tree)
            print(f"Flattened Tree (using {method})")
            tree.display()
            flat = levelOrderTraversal(tree)
            success = (ans == flat)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                break

run_flatten()