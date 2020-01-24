/**
LeetCode Submitted : No (Time Limit Exceeded)
Space Complexity : O(t)
Time Complexity : O(S*t)

The idea is to use 2 pointers (start/end) to keep track of minimum possible window for each possible substring which contains all characters of the T string. We are using hashmap to keep track of these charcters and their frequency. Lastly, we will find substring with minimum window.
**/

class Solution {
    public String minWindow(String s, String t) {
        
        if(s == null || t == null)
            return "";
        
        if(s.length() < t.length())
            return "";
        
        int start = 0;
        int end   = 0;
        
        //Adding the mapping for characters for String "T"
        Map<Character,Integer> map = new HashMap<>();
        
        int window = Integer.MAX_VALUE;
        String result = "";
        
        for(int i = 0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),1);
            }else{
                int count = map.get(t.charAt(i));
                map.put(t.charAt(i),count+1);
            }
        }
        
        
        while(start < s.length() && end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                //count ++;
                map.put(c,Math.max(0,map.get(c) - 1));
            }
            
            
            int sum = map.values().stream().reduce(0, Integer::sum);
            
            if(sum == 0){
                //window = Math.min(window,Math.abs(start-end));
                if(Math.abs(start-end) < window){
                    //System.out.println(window);
                    window = Math.abs(start-end);
                    result = s.substring(start,end+1);
                }
                start = start + 1;
                while(start < s.length() && !map.containsKey(s.charAt(start))){
                    char c1 = s.charAt(start);
                    start++;
                }
                
                 for(int i = 0;i<t.length();i++){
                        int count = map.get(t.charAt(i));
                        map.put(t.charAt(i),count+1);
                    }
                //start--;
                end = start-1;
            }
            
            end++;
            
        }
        return result;
        
    }
}
