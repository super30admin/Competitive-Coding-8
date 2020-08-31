/*
  Time: O(s+t)
  Space: O(1)
  Run on LeetCode: yes
*/
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hmp = new HashMap<>();
        int need = t.length();

        for(int i = 0 ; i < t.length(); i++){
            hmp.put(t.charAt(i), hmp.getOrDefault(t.charAt(i),0)+1);
        }

        int sindx = 0;
        int eindx = 0;
        String str = "";
        while(sindx < s.length() && eindx < s.length()){
            //move endpoint of window. till need > 0
            while(eindx < s.length() && need > 0){
                char ch = s.charAt(eindx);
                if(hmp.containsKey(ch)){
                    int cnt = hmp.get(ch);
                    //if cnt > 0, reduce need.
                    if(cnt > 0){
                        need--;
                    }
                    hmp.put(ch, cnt-1);
                }
                eindx++;
            }


            //we are a possible answer.
            //move strtpoint for window till need <= 0.
            while(sindx < eindx && need <= 0){

                //store possible answers, in str.
                if( (eindx - sindx) < str.length() || str.length() == 0){
                    str = s.substring(sindx, eindx);
                }
                char ch = s.charAt(sindx);
                if(hmp.containsKey(ch)){
                    int cnt = hmp.get(ch);
                    //if cnt becomes == 0 or > 0 ,
                    //we know one more char is needed to get anser ,
                    //so inc need
                    if(cnt >= 0){
                        need++;
                    }
                    hmp.put(ch, cnt+1);
                }
                sindx++;
            }
        }
        return str;
    }
}
