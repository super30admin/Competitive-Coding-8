// Time Complexity : O(M+N), M-> no of characters in string t, N-> no. of characters in string s
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Since we need to find a substring in string s such that all characters of t are found in s, we need to create. afrequency map for t.
// Frequency map will keep track of all characters in t with its frequency.
// Whenever a matching character is found, it is decremented from freq map and a counter is increased.
// Whenever counter reaches the length of string t, the length is observed and if it is minimum, current result is captured. Also, the window is shifted to check further if even smaller substring exists containing all characters of t.
// This approach uses a sliding window concept wherein the right pointer determines the end of iteration.

class Solution {
    public String minWindow(String s, String t) {
        // edge cases
        if(s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        
        int tLen = t.length();
        int sLen = s.length();
        
        if(tLen > sLen) return "";
        
        // creating frequency map of string t
        int[] tMap = new int[128];
        for(int i = 0; i < tLen; i++) {
            tMap[t.charAt(i)-'A']++;
        }
        
        // left and right pointers will be used for maintaining the window
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE; // to capture length of string
        StringBuilder sb = new StringBuilder(); // to capture current string
        int count = 0; // maintaining count to check if it has reached the length of string t
        
        // iterate over string s
        for(right = 0; right < sLen; right++) {
            char ch = s.charAt(right); 
            if(tMap[ch-'A'] > 0) // if string t contains this character in s
                count++;
            tMap[ch-'A']--; // decrementing the frequency count as it has already been seen
            
            while(count == tLen) {
                minLen = Math.min(minLen, right-left+1);
                if(minLen == right-left+1) {
                    sb.setLength(0); // clear existing value in stringbuilder
                    sb.append(s.substring(left, right+1)); // update stringbuilder with new value
                }
                // Now shift the window and try to find another combination. Its possible that the current length is not the minimum one
                char chLeft = s.charAt(left);
                tMap[chLeft-'A']++; // add the starting letter back to tmap
                if(tMap[chLeft-'A'] > 0)
                    count--; // this step will make sure that the next left is at a character which exists in the map.
                left++;
            }
        }
        return sb.toString();
    }
}

