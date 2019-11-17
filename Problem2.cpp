/* Problem Statement:

VERIFIED ON LEETCODE PLATFORM 
76. Minimum Window Substring
Hard

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.



 * Solution 1: USING 2 pointers 
   Time Complexity : O(n),
 * Space complexity :O(n)
 */

class Solution {
public:
    string minWindow(string s, string t) {
        int idx = 0;
        string final_result;
        /* Create hash map of all characters part of string t*/
        unordered_map<char, int> tmap;
        int tt_count = t.size(), t_count = 0;
        int s_count = s.size();
        int t_char_count = 0;
        int start = 0;
        int end = 0;
        int min_window_size = INT_MAX, curr_window = 0;
        unordered_map<char, int>::iterator iter;
        
        /* base case */
        if (tt_count == 0 || s_count == 0) {
            return final_result;
        }
        
        for (idx = 0; idx < t.size(); idx++) {
            iter = tmap.find(t[idx]);
            if (iter != tmap.end()) {
                tmap[t[idx]] = iter->second + 1;    
            } else {
                t_count++;
                tmap[t[idx]] = 1;
            }
        }
        
        /* We will also need to keep track of characters present in the current sliding window */
        unordered_map<char, int> wmap;
        
        while(end < s_count) {
            /* first find the count of characters and update the window */
            iter = wmap.find(s[end]);
            if (iter != wmap.end()) {
                wmap[s[end]] = iter->second + 1;
            } else {
                wmap[s[end]] = 1;
            }
            
            /* Are we interested in this character ? */
            iter = tmap.find(s[end]);
            if (iter != tmap.end()) {
                /* Check if the frequency of char matches with current window frequency */
                if (iter->second == wmap[s[end]]) {
                    t_char_count++;
                }
            }

            /* Check if char count for string t is matching with current t_char_count for the current window*/
            while (t_char_count == t_count && start <= end) {
                curr_window = end - start + 1;
                /* if the window is smaller than current min window update it */
                if (curr_window < min_window_size) {
                    min_window_size = curr_window;
                    final_result = s.substr(start, curr_window);
                }
                
                /* We will try to squeeze the window now, so remove char from window */
                iter = wmap.find(s[start]);
                if (iter != wmap.end()) {
                    wmap[s[start]] = iter->second - 1;
                }

                /* Are we interested in this character ? if yes update the char count now :) */
                iter = tmap.find(s[start]);
                if (iter != tmap.end()) {
                    /* Check if the frequency for the char now is less than the required number then decrease the count */
                    if (wmap[s[start]] < iter->second) {
                        t_char_count--;
                    }
                }
                /* try to squeeze the window now */
                start++;
                
            }
            /* move end pointer also */
            end++;
        }
        return final_result;
    }
};
/* Execute on leetcode platform */


