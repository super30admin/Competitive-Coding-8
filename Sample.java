
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


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
// class Solution {
//     Queue<TreeNode> queue;
//     public void flatten(TreeNode root) {
//         if(root == null) {
//             return;
//         }
//         queue = new LinkedList<>();
//         helper(root);
//         while(!queue.isEmpty()) {
//             TreeNode current = queue.poll();
//             //System.out.println(current.val);
//             current.left = null;
//             current.right = queue.peek();
//         }
//     }
    
//     private void helper(TreeNode root) {
//         if(root == null) {
//             return;
//         }
//         queue.add(root);
//         helper(root.left);
//         helper(root.right);
        
//     }
// }

class Solution {
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        prev = null;
        helper(root);
    }
    private void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.right);
        helper(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}


// Time Complexity : O(M+N)
// Space Complexity : O(M+N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> tmap = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c,0) + 1);
        }
        int required = tmap.size();
        int l = 0;
        int r = 0;
        int formed = 0;
        int[] ans = {-1,0,0};
        HashMap<Character, Integer> window = new HashMap<>();
        
        while(r < s.length()) {
            char c = s.charAt(r);
            window.put(c,window.getOrDefault(c,0) + 1);
            
            if(tmap.containsKey(c) && tmap.get(c) == window.get(c)) {
                formed++;
            }
            while(l <= r && formed == required ) {
                c = s.charAt(l);
                if(ans[0] == -1 || r-l+1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                window.put(c, window.get(c) - 1);
                if(tmap.containsKey(c) && window.get(c) < tmap.get(c)) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        
        if(ans[0] == -1) {
            return "";
        } else {
            return s.substring(ans[1],ans[2]+1);
        }
    }
}