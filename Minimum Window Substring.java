// Time Complexity : O(m+n), m is string s length, n is string t length
// Space Complexity : O(m+n), m is string s length, n is string t length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Using 2 pointers and sliding window
//TC : O(m+n), m is string s length, n is string t length
//SC : O(m+n), m is string s length, n is string t length


//We move end till we find match = mapT.size, all chars of t found, at each move we add to map and check
//if we find match = mapT.size, we add to result
//then we move start and decrease the sliding window size, and check if char of t is removed, 
//if yes, reduce match, if match reduces, we start moving end, 
//we do till end checks all char and start <= end with match = mapt.size
class Solution {
    public String minWindow(String s, String t) {
        //if any string empty, return 0
        if(s.length() == 0 || t.length() == 0) return "";
        //Create Hashmap for t : add all chars of t in map with count of occurance
        HashMap<Character, Integer> mapT = new HashMap<>();
        //Map to keep track of chars in sliding window
        HashMap<Character, Integer> mapSubString = new HashMap<>();
        
        int n = s.length();
        //result array : 0 : size, 1 : start position, 2 : end position
        int[] result = new int[3];
        //set initial length as -1
        result[0] = -1;
        
        //add all chars of t in map
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapT.put(c, mapT.getOrDefault(c,0) + 1);
        }
        
        //initially match = 0, start and end = 0
        int match = 0; 
        int start = 0;
        int end = 0;
        //move end till end of s
        while(end < n) {
            //incoming char
            char cend = s.charAt(end);
            //put to map
            mapSubString.put(cend, mapSubString.getOrDefault(cend,0)+1);
            //check if char is there is mapt and its val is also same
            //intValue() for very long strings
            //if condition satisfies, inc match
            if(mapT.containsKey(cend) && mapT.get(cend).intValue() == mapSubString.get(cend).intValue()) {
                match++;
            }
            //if match = mapt.size() and start<=end
            //then move start
            while (start <= end && match == mapT.size()) {
                //outgoing char
                char cstart = s.charAt(start);
                //before that add to result (match = mapt enters the loop only)
                if(result[0] == -1 || result[0] > end-start+1){
                    result[0] = end-start+1;
                    result[1] = start;
                    result[2] = end;
                }
                //remove from map (dec count by 1)
                mapSubString.put(cstart, mapSubString.get(cstart)-1);
                //check if char removes was in mapt and if yes, check if current window does not have 
                //all chars of t, if yes, dec match
                if(mapT.containsKey(cstart) && mapT.get(cstart).intValue() > mapSubString.get(cstart).intValue()) {
                    match--;
                }
                //inc start, (loop ends, if match != mapTsize / start > end), then end increments
                start++;                            
            }
            //move end if curr window does not have all match
            end++;
        }  
        //if result = -1, then no substring found, so return empty
        if(result[0] == -1) {
            return "";
        }
        //else return, substring between result[1] and result[2] including
        else {
            return s.substring(result[1], result[2]+1); 
        }
    }    
}

