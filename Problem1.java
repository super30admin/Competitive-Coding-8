//time o(s+t) , s - string s length, t- string t length
//space o(t)
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t== null || s.length() < t.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<t.length();i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int minLeft = 0;
        int min = s.length()+1;
        int count = 0;
        int left=0, right=0;
        
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) >= 0)
                {
                    count++;
                }
                
                while(count == t.length()) {
                    if(right-left+1 < min) {
                        min = right-left+1;
                        minLeft = left;
                    }
                    char chleft = s.charAt(left);
                    if(map.containsKey(chleft)) {
                        map.put(chleft, map.get(chleft)+1);
                        if(map.get(chleft) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }
        if(min > s.length())
            return "";
        return s.substring(minLeft, minLeft + min);
    }
}