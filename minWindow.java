//Time complexity: O(M+N)
//Space complexity: O(N) //length of T
import java.util.*;
class minWin {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || s.length() < t.length())
            return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int left = 0;
        int minLeft = 0;
        int len = s.length() + 1;
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0){
                    count++;
                }
                while(count == t.length()){
                    if(i - left + 1 < len){
                        minLeft = left;
                        len = i - left + 1;
                    }
                    
                    char lc = s.charAt(left);
                    if(map.containsKey(lc)){
                        map.put(lc, map.get(lc) + 1);
                        if(map.get(lc) > 0)
                            count--;
                    }
                    
                    left++;
                }
            }
        }
        
        if(len > s.length()){
            return "";
        }
        
        return s.substring(minLeft, minLeft + len);
    }
}