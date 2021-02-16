// Time Complexity : The time complexity is O(n) where n is the length of the string s
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {

        String output = "";
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int count = 0;

        Map<Character,Integer> map = new HashMap<>();

        // Store the frequency of each character of t
        for(int i=0;i<t.length();i++){

            char ch = t.charAt(i);

            if(!map.containsKey(ch)){
                map.put(ch,1);
                count++;
            }
            else{
                map.put(ch,map.get(ch)+1);
            }

        }

        while(end < s.length()){

            char ch = s.charAt(end);

            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);

                if(map.get(ch) == 0){
                    count--;
                }
            }

            // count zero represents that we found all the characters in the window
            while(count == 0){

                min = Math.min(min,end-start+1);

                if(min == end-start+1){
                    output = s.substring(start,end+1);
                }

                char c = s.charAt(start);

                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);

                    if(map.get(c) == 1){
                        count++;
                    }
                }
                start++;
            }

            end++;
        }

        return output;

    }
}