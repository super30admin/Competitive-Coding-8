# Competitive-Coding-8

Please submit the interview problems posted in slack channel here. The problems and statements are intentionally not shown here so that students are not able to see them in advance 



## Problem 1 - String - (https://leetcode.com/problems/minimum-window-substring/description/)

In this approach first we are storing the count of the frequency of characters in string t and maintaining a sliding window with two pointers i and j to find minimum window in s that contains all characters in t. We will be expanding the window by moving the j pointer and updating the hashmap. When the window will contain all the characters from t we will contract the i pointer by moving it to find the smallest possible window. We will track the smallest window by tracking and updating i and j that satisfies the condition.



## Problem 2 - Trees - (https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/)

In this approach we are recursively flattening the left subtree and then moving it to the right of the current node and setting the left child to nukk. Then we are attching the original right subtree tto the end of the newly placed right subtree. Then we are recursively flattening the newly modified right subtree.


