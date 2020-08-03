
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


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
class Solution {
    public void flatten(TreeNode root) {
        //base
        if(root == null || root.left==null && root.right==null) // if root becomes null or we reach leaf node
            return;
        
        //logic
       
         flatten(root.left); // flattening the left first
         TreeNode temp = root.right; // point a temp to root's right
         root.right = root.left; // shift root left to root right
         root.left = null; // make root left as null 
         while(root.right!=null) // iterate over the added nodes to root right till we hit null
         {
            root = root.right;
         }
         root.right = temp;   // now point the root right to the initially right subtree marked by temp
       
        flatten(root.right); // call flatten on root's right
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None

class Solution {
    public String minWindow(String s, String t) {
        //edge case
        if(s.length()==0 || t.length()==0)
            return "";
            //to store freq of each character in t
        Map<Character, Integer> tmap = new HashMap<>();
        
        for(int i=0;i<t.length();i++)
        {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }
        //to check when we have the required characters
        int required = tmap.size();
        int l=0;
        int r=0;
        int formed = 0;
        Map<Character, Integer> smap = new HashMap<>();
        int ans[] = {-1,0,0}; // to store size, left and right boundary of found string
        while(r<s.length())
        {
            char c = s.charAt(r); // get character at r
            smap.put(c,smap.getOrDefault(c,0)+1); // put in map for s
            
            if(tmap.containsKey(c) && tmap.get(c).intValue()==smap.get(c).intValue()) // when the frequency of any character matches with that in tmap
            {
                formed++; //  increase formed
            }
            
            while(l<=r && formed == required) // when formed becomes equal to size of tmap
            {
                
                if(ans[0] == -1 || ans[0]>r-l+1) // ans hasnt been updated even once or new strings length is less than what was found earlier
                {
                    //update the values
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                //we will be moving left on finding a possible match and finding if there is a minimum possible substring
                c = s.charAt(l); // get character at l
                smap.put(c, smap.get(c)-1); // decrease its count from smap
                
            if(tmap.containsKey(c) && tmap.get(c).intValue()>smap.get(c).intValue()) // on decreasing value from smap if freq does not match with t
            {
                formed--; // decrease formed
            }
                l++; //increase l
            }
            r++; // incraese till we find a match
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1); // get substring from left to right+1
    }
}