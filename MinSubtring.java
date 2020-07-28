//Time Complexity: O(s+t) time 
//Space Complexity: O(s+t) space

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        int size = t.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";
        
        // push character:frequency to tmap
        for(int i=0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        int i=0;
        int total=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(!tMap.containsKey(c)){
                continue;
            }
            // if count less than count in t, then increment total
            int count = map.getOrDefault(c, 0);
            if(count < tMap.get(c)){
                total++;
            }
            
            map.put(c, count+1);
        
            // when total reaches size of t, start trimming from left till no more characters can be trimmed
            if(total == size){
                while(!tMap.containsKey(s.charAt(i)) || map.get(s.charAt(i)) > tMap.get(s.charAt(i))){
                    char pc = s.charAt(i);
                    if(tMap.containsKey(pc) && map.get(pc) > tMap.get(pc)){
                        map.put(pc, map.get(pc)-1);
                    }

                    i++;
                }

                if(minLen > j-i+1){
                        minLen = j-i+1;
                        result = s.substring(i, j+1);
                }
            }  
        }
        return result;
    }
}