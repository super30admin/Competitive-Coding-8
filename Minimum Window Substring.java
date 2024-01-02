//  Time Complexity: O(n)
//  Space Complexity: O(n)
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int len = Integer.MAX_VALUE;
        int match = 0;
        int start_index = 0;
        int end_index = 0;
        Map<Character, Integer> map  = new HashMap<>();

        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i=0, j=0;
        while(i<=j && j< s.length()){

            if(match == map.size()){

                if(map.containsKey(s.charAt(i)))
                {
                    if(len > j-i){
                        start_index = i;
                        end_index = j;
                        len = j - i;
                    }
                    char out = s.charAt(i);
                    map.put(out, map.get(out) + 1);
                    if(map.get(out) == 1) match--;
                }
                i++;
                continue;     
            }
            
            char c = s.charAt(j);

            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) match++;
            }
            j++;
        }

        while(match == map.size()){

            if(map.containsKey(s.charAt(i)))
            {
                if(len > j-i){
                    start_index = i;
                    end_index = j;
                    len = j - i;
                }
                char out = s.charAt(i);
                map.put(out, map.get(out) + 1);
                if(map.get(out) == 1) match--;
            }
            i++;
        }
        return s.substring(start_index, end_index);
    }
}