/*
Time complexity: O(M+N) where M is length of String S and N is length of String T
Space complexity: O(M) where M is length of String T or may be constant if we have 26/52  chars
*/
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        //count would be count of char we need to find in the cur window
        int count=t.length();
        int start=0, end=0;
        int startPos=0, endPos=0;
        int curLen, minLen=Integer.MAX_VALUE;
        //iterate over the string 
        while(end < s.length() && start<s.length()){
            //insert count into map till count becomes zero
            char ce = s.charAt(end++);
            //we would increment the window till we find all the chars in String T 
            if(map.containsKey(ce)){
                map.put(ce, map.getOrDefault(ce,0)-1);
                if(map.get(ce) >= 0)
                    count--;
            }
            //we found all the char in our window, now try to shrink the window from the start just to see
            //if we can have all the chars in the window with minimum size. 
            while(count==0 && start<s.length()){ 
                curLen = end - start;
                //get the current window
                if(minLen > curLen){
                    startPos = start;
                    endPos = end; 
                    minLen= curLen;
                }
                //remove start char from window, increment its count in the map
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start),map.getOrDefault(s.charAt(start),0)+1);
                    //if count is greater than 0 that means we need to find this char for the cur window
                    //increment count;
                    if(map.get(s.charAt(start))>0)
                        count++;
                    //if character count in map is less than 0 means we still have this char in our cur window
                    //so we dont increment count in that case.
                }
                //increment start
                start++;
            }              
        }
        return s.substring(startPos, endPos);  
    }
}
