// Time Complexity :O(S+T)
// Space Complexity :O(S+T)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class MinWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            if(s==null || s.length() ==0) return "";//edge case

            String result="";
            int[] charCount = new int[128];//array to keep count of characters, 128 for ascii
            int left =0, count=0, minLen=Integer.MAX_VALUE;

            //get frequency count in t
            for(char c:t.toCharArray()){
                charCount[c]++;
            }


            return result;
        }
    }



}
