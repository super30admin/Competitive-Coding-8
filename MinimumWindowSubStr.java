//TC - O(S + T)
//SC - O(k) - distinct characters in string t
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t.length() == 0 || t == null){
            return null;

        }
        int match = 0;
        int minLen = s.length() + 1;
        int start = 0;
        int substr = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        for(int j = 0; j < s.length(); j++){
            char incomming = s.charAt(j);
            if(map.containsKey(incomming)){
                int cnt = map.get(incomming);
                cnt--;
                map.put(incomming,cnt);
                if(cnt == 0){
                    match++;
                }

            }
            while(match == map.size()){
                if(minLen > j - start + 1){
                    minLen = j - start + 1;
                    substr = start;
                }
                char outgoing = s.charAt(start++);
                if(map.containsKey(outgoing)){
                    if(map.get(outgoing) == 0) match--;
                    map.put(outgoing,map.get(outgoing) + 1);
                    
                    
                }

                
            }

        }
       return minLen > s.length() ? "" : s.substring(substr, substr + minLen); 
    }
}