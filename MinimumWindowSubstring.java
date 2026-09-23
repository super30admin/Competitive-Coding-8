//Time Complexity: O(m) + O(n)
//Space Complexity: O(1)
class Solution {
    public String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE;
        int start = 0, end = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int slow = 0;
        int match = 0;

        for(int i=0; i<s.length(); i++){
            char in = s.charAt(i);
            if(map.containsKey(in)){
                int frq = map.get(in);
                frq--;
                map.put(in, frq);
                if(frq == 0) match++;
            }

            if(match < map.size()) continue;

            while(match == map.size()){
                char out = s.charAt(slow);
                slow++;
                if(map.containsKey(out)){
                    int frq = map.get(out);
                    frq++;
                    map.put(out, frq);
                    if(frq == 1) match--;
                }
            }

            if(len > i - slow + 2){
                len = i - slow + 2;
                start = slow - 1;
                end = i;
            }
        }

        if(len == Integer.MAX_VALUE) return "";
        return s.substring(start, end + 1);
    }
}
