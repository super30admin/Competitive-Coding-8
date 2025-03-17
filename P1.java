/*
Time Complexity (TC)
O(N + M), where
N is the length of s
M is the length of t
We traverse s at most twice: once expanding (r pointer) and once contracting (l pointer), making it O(N).
Constructing the frequency array for t takes O(M).
Overall, O(N + M) ≈ O(N).

Space Complexity (SC)
O(1) because the frequency array (hash) has a fixed size of 256, which is constant.

We first build a frequency array hash for characters in t, then use two pointers (l and r) to expand and contract the window dynamically.
As we expand (r), we decrement hash[s.charAt(r)] and increase count when a needed character is found.
Once all characters are matched (count == t.length()), we attempt to shrink the window (l++) while updating the minimum window length, finally returning the smallest valid substring.
 */

class Solution {
    public String minWindow(String s, String t) {
        

        int minLen = Integer.MAX_VALUE;

        int sIndex = -1;
        

        int[] hash = new int[256];

        for (char c : t.toCharArray()) {
            hash[c]++;
        }
            
        int count = 0;
        int l = 0, r = 0;

        while (r < s.length()) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
                

            while (count == t.length()) {
                    

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
