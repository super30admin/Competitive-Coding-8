// Time Complexity : O(m+n) where m and n are the lengths of Strings s and t.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We need to store the frequencies of t string characters in a HashMap. two pointers left and right on string s and move the right pointer until
// we find a substring that has all chars of t with the help of counter. Now we shrink the window by moving left pointer until the counter is as of t's length.
// Capture minimum length and start point at each possible substring with all chars of t and return the minimum length one.

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char ch: t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch,0)+1); //store all t chars in tMap
        }
        int m = s.length();
        int n = t.length();
        int minLen = Integer.MAX_VALUE;
        int counter = 0;
        int left = 0; //left pointer
        int right = 0; //right pointer
        int start = -1; //to capture start character of minimum length string
        while(right < m){ //moving right pointer until end of string
            char ch = s.charAt(right);
            if(tMap.containsKey(ch)){ //when match found in hashmap
                if(tMap.get(ch) > 0){
                    counter++;//increase counter
                }
                tMap.put(ch, tMap.get(ch) - 1);//update hashmap
            }
            while(counter == n){ //while counter is of n length
                if(minLen > right-left+1){
                    start = left;//update start point of required min length string
                    minLen = right-left+1;//update min length
                }
                char leftChar = s.charAt(left);//to shrink the window from left
                if(tMap.containsKey(leftChar)){
                    tMap.put(leftChar, tMap.get(leftChar) + 1);//update hashmap
                    if(tMap.get(leftChar) > 0){
                        counter--;//reduce counter as we lost a char in hashmap
                    }
                }
                left++;//move left pointer
            }
            right++;//move right pointer
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(start, start+minLen);
    }
}