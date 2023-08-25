// Time Complexity :O(s + t)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int zToA = 'z' - 'A' + 1;
        int [] tFrequencies = new int[zToA];

        //Getting frequency of characters in String t
        for(char c : t.toCharArray()){
            tFrequencies[c - 'A']++;
        }

        int requiredCount = t.length();
        int minLength = Integer.MAX_VALUE;
        int startIdx = 0;

        int left = 0;
        int right = 0;
        char [] sArr = s.toCharArray();
        //Going through all the characters in String s to find the substring
        while(right < n) {
            char c = sArr[right];
            if (tFrequencies[c - 'A'] > 0) {
                requiredCount--;
            }
            tFrequencies[c - 'A']--;
            right++;

            while (requiredCount == 0) {
                char d = sArr[left];
                if (right - left < minLength) {
                    startIdx = left;
                    minLength = right - left;
                }
                if (tFrequencies[d - 'A'] == 0) {
                    requiredCount++;
                }
                tFrequencies[d - 'A']++;
                left++;

            }
        }
        return minLength == Integer.MAX_VALUE ? "" : new String(sArr, startIdx, minLength);
    }
}