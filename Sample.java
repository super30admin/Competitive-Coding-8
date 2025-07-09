
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
        // --- 1. Edge Case and Setup ---
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Create a "blueprint" map of characters needed from t.
        Map<Character, Integer> targetCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCounts.put(c, targetCounts.getOrDefault(c, 0) + 1);
        }

        // --- 2. Sliding Window Variables ---
        int left = 0; // Left pointer of the window.
        Map<Character, Integer> windowCounts = new HashMap<>(); // Counts of chars inside the window.

        int need = targetCounts.size(); // The number of unique characters we need to find.
        int have = 0; // The number of unique characters we have satisfied.

        // Variables to store the best result found so far.
        int resultLength = -1;
        int resultStart = 0;

        // --- 3. Main Loop (Expand and Contract Window) ---
        for (int right = 0; right < s.length(); right++) {
            // EXPAND the window from the right.
            char charRight = s.charAt(right);
            windowCounts.put(charRight, windowCounts.getOrDefault(charRight, 0) + 1);

            // Check if adding this character satisfied one of our needs.
            if (targetCounts.containsKey(charRight) && windowCounts.get(charRight).equals(targetCounts.get(charRight))) {
                have++;
            }

            // CONTRACT the window from the left as long as it's valid.
            while (have == need) {
                // First, see if this current window is the best one yet.
                int currentLength = right - left + 1;
                if (resultLength == -1 || currentLength < resultLength) {
                    resultLength = currentLength;
                    resultStart = left;
                }

                // Get the character that is about to be removed from the left.
                char charLeft = s.charAt(left);

                // **FILLED IN THIS PART:**
                // Remove the left character from our window's count.
                windowCounts.put(charLeft, windowCounts.get(charLeft) - 1);

                // Check if removing this character made our window invalid.
                if (targetCounts.containsKey(charLeft) && windowCounts.get(charLeft) < targetCounts.get(charLeft)) {
                    have--; // If so, we no longer "have" this needed character.
                }

                // Move the left pointer to shrink the window.
                left++;
            }
        }

        // --- 4. Return the Final Result ---
        // If resultLength was never updated, we didn't find a valid window.
        if (resultLength == -1) {
            return "";
        } else {
            // Otherwise, extract the substring we found.
            return s.substring(resultStart, resultStart + resultLength);
        }
    }
}
//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode prev = null;

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

    }
}