class Solution {

    // Time Complexity = O(m+n), m length of string s and n length of string t
// Space Complexity = O(m) + O(26) -> O(m), where m is the length of string s
    //Did it successfully run on leetcode: yes
    //Did you face any problem while coding: No

    //In short explain your approach

    public String minWindow(String s, String t) {
        // we need hashmap to save the counts of the characters
        HashMap<Character, Integer> map = new HashMap<>();
        // convert the pattern into a hashmap to know the count of chars need for t
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int j = 0;
        int match = 0;
        int start = 0;  // store the start and end of the substring to return
        int end = 1;
        int min = Integer.MAX_VALUE;
        while(j < s.length()){
            char in = s.charAt(j);
            j++;//move j ahead
            // reduce count if found
            if(map.containsKey(in)){
                int count = map.get(in);
                map.put(in, --count);
                if(count == 0){ // found match of that char
                    match++;
                }
            }
            // check if matched equals to size of the map
            // if yes then keep moving i pointer till you find min window possible and all chars are still matching
            while(match == map.size()){
                // find the new min start idx
                if(min > j-i){
                    start = i;
                    end = j;
                    min = j-i;       //update min
                }
                char out = s.charAt(i); // update count of out going char
                if(map.containsKey(out)){
                    int count = map.get(out);
                    map.put(out, ++count);
                    if(count == 1){ // increased the required match
                        match--;
                    }
                }
                i++;    // keep reducing start of index
            }
        }
        if(min == Integer.MAX_VALUE){   // did not find any matching
            return "";
        }
        return s.substring(start, end);
    }
}