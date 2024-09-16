// Time Complexity : O(S + T)
// Space Complexity : O(S + T)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, this is a hard problem.  Had to look up the solution.  I still don't fully
// understand the optimized solution.  Will need to go over the video/wait for class.

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if (!s.length || !t.length) return "";
    
    const charCount = new Map();
    for (const char of [...t]) {
        const count = charCount.get(char) || 0;
        charCount.set(char, count + 1);
    }
    
    const totalChars = charCount.size;
    let left = 0,
        right = 0,
        formed = 0;
    
    const windowCharCount = new Map();
    let ans = [-1, 0, 0];
    
    while (right < s.length) {
        let char = s[right];
        const count = windowCharCount.get(char) || 0;
        windowCharCount.set(char, count + 1);
        
        if (charCount.has(char) && windowCharCount.get(char) == charCount.get(char)) formed++;
        while (left <= right && formed == totalChars) {
            char = s[left];
            if (ans[0] == -1 || right - left + 1 < ans[0]) {
                ans[0] = right - left + 1;
                ans[1] = left;
                ans[2] = right;
            }
            
             windowCharCount.set(char, windowCharCount.get(char) - 1);
            if (charCount.has(char) && windowCharCount.get(char) < charCount.get(char)) formed--;
            left++;
        }
        right++;
    }
    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
};
