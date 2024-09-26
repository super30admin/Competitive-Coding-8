class MinimumWindowSubstring {

    // Time Complexity: O(2*m + n) -- O(m + n)  (where m -> len(s) and n -> len(t))
    // Space Compexity: O(n)
    
    public String minWindow(String s, String t) {
        // Edge Case Checking
        if(s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";
        
        // Creating a map of characters of String t (frequency map)
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        
        // Getting the count --> required number of characters in a window in String s
        int count = map.size();
        int i = 0, j = 0, left = 0, right = 0, minLen = s.length();
        boolean found = false;
        
        while(j < s.length()){
            char c = s.charAt(j++);
            // If map contains the current character --> decrement its count from the map
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                // If the character count becomes zero --> that means we satisfied that character count in our current window in String s
                if(map.get(c) == 0)
                    count--;
            }
            
            // If we haven't found a window with all characters in String t --> continue traversing String s
            if(count > 0)
                continue;
            
            // Once we find all characters in t in our window in s --> try to reduce the window
            while(count == 0){
                char startChar = s.charAt(i++);
                if(map.containsKey(startChar)){
                    // If the map contains the start character --> update the frequency map as well increase the count
                    map.put(startChar, map.get(startChar)+1);
                    if(map.get(startChar) > 0)
                        count++;
                }
            }
            
            // If we find a smaller window --> update the window
            if((j-i) < minLen){
                minLen = j - i;
                left = i;
                right = j;
                found = true;
            }
        }
        
        return found ? s.substring(left-1, right) : "";
    }
}