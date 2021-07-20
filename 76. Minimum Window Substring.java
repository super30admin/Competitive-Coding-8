class Solution {
    // Time complexity: O(m+n), m and n indicate the length of s and t
    // Space complexity: O(n), n indicates the length of t
    public String minWindow(String s, String t) {
        // set sliding window's pointers
        int winStart = 0; 
        // initialize one pointer to record the left of substring
        int subStrStart = 0;
        // initialize the minimum length of substring
        int minLength = s.length() + 1;
        int matched = 0;
        // construct map to record the occurences in the patten t
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // then, try to extend the range of the window
        for(int winEnd = 0; winEnd < s.length(); winEnd++){
            char right = s.charAt(winEnd);
            // check whether the char here existed in pattern t
            if(map.containsKey(right)){
                // then we need decrement the value of the key
                map.put(right, map.get(right) - 1);
                // since we find one matched char, so we should increase the matched count
                if(map.get(right) >= 0) // we should check whether we have found all chars in pattern t, if we did, then no need to increase matched count
                    matched++;
            }
            // we should shink the window, once we get one substring which includes all pattern k
            while(matched == t.length()){
                // check whether current substring is the shortest one
                if(minLength > winEnd - winStart + 1){
                    minLength = winEnd - winStart + 1;
                    // move the the start pointer of substring (subStrStart) in terms of the winStart
                    subStrStart = winStart;
                }
                
                char left = s.charAt(winStart++); // do not forget to move the winStart
                
                if(map.containsKey(left)){
                    // since we may have redundant matching characters, for example, we may have two a's in the sliding window, but t only have one a, so we need decrement the matched count when a useful matched char is removed from the map
                    // we may have two a's in the sliding window, but t only have one a, so maybe the value of the key will be negative
                    if(map.get(left) == 0) // this indicates we have removed the useful chars in the pattern
                        matched --;
                    map.put(left, map.get(left) + 1); // we need add 1 back to the value of k
                }
            }
        }
        
        return minLength > s.length()? "":s.substring(subStrStart, subStrStart + minLength);
    }
}