
// Time Complexity : O(n) where n is length of string s as each character is processed at most twice.
// Space Complexity : O(m) where m is the length of the string t as we are storing characters of t in hashmap.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed the tutorial


// Your code here along with comments explaining your approach
// In this approach first we are storing the count of the frequency of characters in string t and maintaining a sliding window with two pointers i and j to find
// minimum window in s that contains all characters in t. We will be expanding the window by moving the j pointer and updating the hashmap. When the window will
// contain all the characters from t we will contract the i pointer by moving it to find the smallest possible window. We will track the smallest window by 
// tracking and updating i and j that satisfies the condition.

class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        int m = t.length();

        if(n == 0 || m == 0 || m > n) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            char c = t.charAt(i);

            if(!map.containsKey(c)) {
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);
        }

        int match = 0;
        int tempLoc = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        String result = "";

        while(i <= j && i < n) {
            if(match == map.size()) {
                tempLoc = Math.min(tempLoc, j-i);

                if(tempLoc == j-i) {
                    result = s.substring(i, j);
                }
            }

            if(i != j && (match == map.size() || j == n)) {
                char c = s.charAt(i);

                if(map.containsKey(c)) {
                    if(map.get(c) == 0) {
                        match = match - 1;
                    }
                    map.put(c, map.get(c) + 1);
                }

                i = i + 1;
            } else {
                char c = s.charAt(j);

                if(map.containsKey(c)) {
                    if(map.get(c) == 1) {
                        match = match + 1;
                    }
                    map.put(c, map.get(c) - 1);
                }

                j = j + 1;
            }
        }

        return result;

    }
}



// Time Complexity : O(n) where n is number of nodes in the tree as we are processing each node at least once.
// Space Complexity : O(h) where h is the height of the tree which will be equal to size of the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed given tutorial


// Your code here along with comments explaining your approach
// In this approach we are recursively flattening the left subtree and then moving it to the right of the current node and setting the left child to nukk. Then we
// are attching the original right subtree tto the end of the newly placed right subtree. Then we are recursively flattening the newly modified right subtree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        
        // base
        if(root == null) {
            return;
        }

        // logic
        if(root.left != null) {
            flatten(root.left);

            TreeNode tempRight = root.right;

            root.right = root.left;
            root.left = null;

            while(root.right != null) {
                root = root.right;
            }

            root.right = tempRight;
        }

        flatten(root.right);


    }
}