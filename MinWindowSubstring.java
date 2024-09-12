// Time Complexity : O(s + t) where s is the length of the string 1 and t is length of string 2
// Space Complexity : O(s + t) where store is storing the t string and window is storing the s string  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficult in coming up with this approach in detail
/* Your code here along with comments explaining your approach: Store the smaller string, t in the store map. While you parse the s string where
we need to search the substring, as we encounter characters we store the characters with their counts in the window hashmap. If the character is
present in both the store and window hashmap and the number of the coccurances are same in both => character is matched, match counter increments. 
When the match variable becomes equal to the store size, we move the start pointer by one character and see any effect has occured in the match. 
If the character that is left out of the window belongs to the store map, match count decrements since we are leaving a character that belongs to t.
And then we again start to find a window such that t is a part of s. Once we find the window, we reduce the size of the window using start.
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null){return "";}
        int[] ans = {-1,0,0};
        HashMap<Character, Integer> store = new HashMap<>();                                                // Store t string
        HashMap<Character, Integer> window = new HashMap<>();                                               // Store the window characters
        int start =0,  j =0;
        for(int i= 0; i < t.length(); i++){
            store.put(t.charAt(i), store.getOrDefault(t.charAt(i), 0) + 1);                                         // Storing character and counts of t
        }
       int match  = 0;
        while(j  < s.length()){
            char c = s.charAt(j);
            window.put(c, window.getOrDefault(c, 0) + 1);                                                       // Get the character of s string
            if(store.containsKey(c) && store.get(c).intValue() == window.get(c).intValue()){                    // If the character is in both the maps
                   match++;                                                                                     // Matched character count increments
             } 
            while(start <= j && match == store.size()){                                                         // When the match becomes equal to store size
                if(ans[0] == -1 || ans[0] > j - start + 1){                                                     // If the current length of substring is lesser than the previous length
                ans[0] = j - start + 1;
                ans[1] = start;                                                                                     // Update the length and the indices
                ans[2] = j;
                }
                c = s.charAt(start);                                                                            // Character left out of the window
                window.put(c, window.get(c) - 1);                                                           // Out of the window and hence its occurance is not there anymore in the window
                if(store.containsKey(c) && window.get(c) < store.get(c)){               
                    match--;                                                                                // If the character left out is a part of the store map
                }                                                                                   
                start++;                                                                                    // Move the start pointer to reduce the window size
            }
            j++;                                                                                            // We continue to find the next window with all characters of t in s
            }

        StringBuilder sb = new StringBuilder();
        for(int m = ans[1]; m <= ans[2] ; m++){
            sb.append(s.charAt(m));                                                                     // Print the string from start to j window (min)
        }
        if(ans[0] == -1){
            return "";                                                                                                  // Substring not found!
        }                           
        return sb.toString();
    }
}
