// tc: o(n) sc: o(1)
class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character,Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = 0;
        for(int i=0; i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int match = 0, i=0, j=0, len= Integer.MAX_VALUE;
        while(i<=j && j<s.length()){
            if(match == map.size()){
                char out = s.charAt(i);
                if(map.containsKey(out)){
                    if(len > j-i){
                        startIndex = i;
                        endIndex = j;
                        len = j-i;
                    }
                    map.put(out,map.get(out)+1);
                    if(map.get(out) == 1) match --;
                }
                i++;
                continue;
            }
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c) == 0) match++;
            }
            j++;
        }
        while(match == map.size()){
            char out = s.charAt(i);
            if(map.containsKey(out)){
                if(len > j-i){
                    startIndex = i;
                    endIndex = j;
                    len = j-i;
                }
                map.put(out,map.get(out)+1);
                if(map.get(out) == 1) match --;
            }
            i++;
        }
        return s.substring(startIndex, endIndex);
    }
}
