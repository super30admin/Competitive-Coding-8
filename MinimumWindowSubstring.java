// Time Complexity = O(m+n), m length of string s and n length of string t
// Space Complexity = O(m) + O(26) -> O(m), where m is the length of string s
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || t == null)
            return null;
     
        
        // we need hashmap to save the counts of the characters
        Map<Character, Integer> map = new HashMap<>();
        // convert the pattern into a hashmap to know the count of chars need for t
        for(char c : t.toCharArray()) //O(n)
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        
        int i = 0, j = 0, match = 0;
        int startIdx = 0, endIdx = 1; // store the start and end of the substring to return
        int min = Integer.MAX_VALUE;
        
        while(j < s.length()) // O(m)
        {
            char in = s.charAt(j);
            j++; //move j ahead 
            // reduce count if found
            if(map.containsKey(in))
            {
                int count = map.get(in);
                map.put(in, --count);
                if(count == 0) // found match of that char
                {
                    match++;
                }
            }
            
            // check if matched equals to size of the map
            // if yes then keep moving i pointer till you find min window possible and all chars are still matching
            while(match == map.size())
            {
                // find the new min start idx
                if(min >j-i)
                {
                    startIdx = i;
                    endIdx = j;
                    //update min
                    min = j-i;
                }
                // update count of out going char
                char out = s.charAt(i);
                if(map.containsKey(out))
                {
                    int count = map.get(out);
                    map.put(out, ++count);
                    if(count == 1) // increased the required match
                    {
                        match--;
                    }
                }
                i++; // keep reducing start of index
            }
        }
        
        if(min == Integer.MAX_VALUE) // did not find any matching
            return "";
        return s.substring(startIdx, endIdx);
    }
}
