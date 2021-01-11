// Time - O(T+S)
// Space - O(T)

class Solution {
    public String minWindow(String s, String t) {
        
        if(s==null||s.length() == 0){
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<t.length();i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int match = map.size();
        int min = s.length();
        String result = "";
        int start  = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int cnt = map.get(ch);
                cnt--;
                map.put(ch, cnt);
                if(cnt == 0) {
                    match--;
                }
            }
            
            while(match == 0) {
                int size = i - start + 1;
                if(min >= size) {
                    min = size;
                    result = s.substring(start, i + 1);
                }
                char outgoing = s.charAt(start);
                if(map.containsKey(outgoing)) {
                    int cnt = map.get(outgoing);
                    cnt++;
                    map.put(outgoing, cnt);
                    if(cnt > 0) {
                        match++;
                    }
                }
                start++;
            }
        }
        
        return result;
        
        
    }
}
