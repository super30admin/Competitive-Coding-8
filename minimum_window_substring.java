class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int minimum = s.length();
        for(int i =0; i<t.length();i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int i = 0; 
        int j = 0;
        int startIndex = 0;
        int endIndex = 0;
        int count = map.size();
        int minWindowLength = Integer.MAX_VALUE;
        
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) {
                    count--;
                }
            }
            j++;
            
            while(count == 0) {
                if((j - i) < minWindowLength) {
                    minWindowLength = j - i;
                    startIndex = i;
                    endIndex = j;
                }
                
                char charac = s.charAt(i);
                if(map.containsKey(charac)) {
                    map.put(charac, map.get(charac) + 1);
                    if(map.get(charac) > 0) {
                        count++;
                    }
                }
                i++;
            }
        }

        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, endIndex);
    }
}