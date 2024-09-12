// Time Complexity : O(S + T) S and T are length of the strings
// Space Complexity : O(S + T)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create HashMap and store frequencies of all the characters  of string t
// Now take 2 pointers left and right starting at position 0
// Our target variable would have value equal to the size of hashmap
// We will decrement the count of char in hashmap if we encounter one and increment when left is being moved
// When a character gets frequency 0 then we will decrement the target value increment it when freq becomes 1
// When target becomes 0 we have found the string and keep it in ans if its size is lesser than previous

class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        int n = s.length();
        String ans = "";
        int target = hm.size();
        while(l < (n - t.length()) || r < n){
            if(target != 0 && r < n){
            char c = s.charAt(r++);
            if(hm.containsKey(c)){
                hm.put(c, hm.get(c) - 1);
                if(hm.get(c) == 0)
                    target--;
            }
            }
            else{
                char c = s.charAt(l++);
                if(hm.containsKey(c)){
                    hm.put(c, hm.get(c) + 1);
                    if(hm.get(c) == 1)
                        target++;
                }
            }
            if(target == 0){
                String str = s.substring(l,r);
                if(ans == "" || ans.length() > str.length())
                    ans = str;
            }
        }
        return ans;
    }
}