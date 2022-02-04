class Solution {
    public String minWindow(String s, String t) {
        if(s == t ) return s;
        if(t.length() > s.length()) return "";
        int n = s.length();
        int m = t.length();
        int i = 0; int j = 0;
        int l = 0; int r = n;
        int min = n+1;
        boolean found = false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int k = 0; k < m; k++){
            char ch = t.charAt(k);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        int cnt = hm.size();
        while(j < n){
            char ch = s.charAt(j++);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)-1);
                if(hm.get(ch) == 0){
                    cnt--;
                }
            }
            if(cnt > 0) continue;

            while(cnt == 0){
                char sCh = s.charAt(i++);
                if(hm.containsKey(sCh)){
                    hm.put(sCh, hm.get(sCh)+1);
                    if(hm.get(sCh) > 0){
                        cnt ++;
                    }
                }
            }

            if( j - i < min){
                min = j-i;
                l = i;
                r = j;
                found = true;
            }
        }
        if(found){
            return(s.substring(l-1,r));
        }else{
            return "";
        }
    }
}