// Time Complexity : O(M+N)
//          - M is the length of the string S
//          - N is the length of the string T
// Space Complexity :
//          - In worst case scenario O(M+N)
//          - Ideally we can say that space is constance since the max of O(M+N) is limited by the characters available which is 52. 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Faced little issue in the window compress logic.


// Your code here along with comments explaining your approach

public class MinWindowString {
    public String minWindow(String s, String t) {
        
        String result = "";
        
        if(s == null || s.length() == 0) return result;
        if(t == null || t.length() == 0) return result;
        
        int start = 0; int end = 0;
        int min = Integer.MAX_VALUE;
        
        // Map is used to creating a mapping of character count in the given String S
        Map<Character, Integer> map = new HashMap<>();
        
        // Window is used for creating a map of characters in the window that we are in.
        Map<Character, Integer> window = new HashMap<>();
        
        // Generate the character count for the given string T.
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        }
        
        // Char count is used to mention the required characters for generating window.
        int charCount = map.size();
        // Count is used for keeping a track of all the characters that are added to the calculated window.
        int count = 0;
        
        while(end < s.length()){
            
            // Increment the end pointer until the first character is found.
            char endChar = s.charAt(end);
            if(!map.containsKey(endChar)){
                end++;
                continue;
            }
            // Update the count of current end character into the window map.
            window.put(endChar, window.getOrDefault(endChar, 0)+1);
            
            // If the current window character count is same as the character count in the map, increment the count.
            if(window.get(endChar).intValue() == map.get(endChar).intValue()) count++;
            
            // Try to shrink the window from the start to get the minimum window.
            // Move the start pointer to the right, until we have the count same as required count.
            while(start <= end && count == charCount){
                
                // Fetch the current char associated to the start pointer.
                char startChar = s.charAt(start);
                // skip the current character if it is not present in the required character map.
                if(!map.containsKey(startChar)){
                    start++;
                    continue;
                }
                
                // Compute the window size.
                // Whenever we find a minimum window, update the minimum window and the string associated to the current start and end indices.
                if(end - start + 1 < min){
                    min = end - start + 1;
                    result = (end == s.length()-1) ? s.substring(start) : s.substring(start, end+1);
                }
                
                // Moving the start pointer to right.
                start++;
                // Update the corresponding char count in the window and the count variable as well.
                window.put(startChar, window.get(startChar)-1);
                if(window.get(startChar).intValue() < map.get(startChar).intValue()) count--;
            }
            
            // Move the end pointer to the right after performing computations for respective start and end pointers.
            end++;
        }
        
        // Finally return the generated result.
        return result;
    }
}
