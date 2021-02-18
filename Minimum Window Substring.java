/*
class Solution:
    def minWindow(self, s, t):
        if not t or not s:
            return ""
        
        required = dict()
        for c in t:
            required[c] = required.get(c, 0) + 1
        
        left, right = 0, 0
        formed = 0
        window_counts = {}
        p1, p2 = -1, -1
        min_len = float('inf')

        while right < len(s):
            window_counts[s[right]] = window_counts.get(s[right], 0) + 1

            if s[right] in required and window_counts[s[right]] == required[s[right]]:
                formed += 1

            while left <= right and formed == len(required):
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    p1 = left
                    p2 = right

                window_counts[s[left]] -= 1
                if s[left] in required and window_counts[s[left]] < required[s[left]]:
                    formed -= 1

                left += 1    

            
            right += 1
            
        return "" if min_len == float("inf") else s[p1:p2 + 1]
*/

// Time - O(s+t) where s and t is size of s and and t
// Space - O(s+t) as hashmap for t and also window_count for s which would equal len(s) in case of unique strings
// Logic - first record all chars of t with its freq and then travel on s and maintain a window where we record all chars and freq in it
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null)
            return "";
        
        HashMap<Character, Integer> required = new HashMap<Character, Integer>();
        
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            required.put(c, required.getOrDefault(c, 0) + 1);
        }
            
        
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int left = 0, right = 0, formed = 0, p1 = -1, p2 = -1;
        int min_len = Integer.MAX_VALUE;
        
        while (right < s.length()){
            char c = s.charAt(right);
            
            count.put(c, count.getOrDefault(c, 0) + 1);
            if (required.containsKey(c) && required.get(c).intValue() == count.get(c).intValue()){
                formed ++;
            }
            
            while (formed == required.size() && left <= right){
                if (right - left + 1 < min_len){
                    p1 = left;
                    p2 = right;
                    min_len = right - left + 1;
                }
                c = s.charAt(left);
                count.put(c, count.get(c) - 1);
                if (required.containsKey(c) && required.get(c).intValue() > count.get(c).intValue()){
                    formed --;
                }
                left ++;
            }
            right ++;
        }
        
        if (min_len == Integer.MAX_VALUE){
            return "";
        }
            
        return s.substring(p1, p2+1);
    }
}