class Solution {
    public String minWindow(String s, String t) {

        int resultLow = 0;
        int resultHigh = 0;
        int maxLength = -1;
        int tLength = t.length();
        //Edge
        if(t.length()>s.length() || t == null || t.length() == 0){
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            int freq = map.getOrDefault(c,0);
            map.put(c, freq+1);
        }

        int low=0;
        int high=0;
        for(int i=0; i<s.length();i++){
            char c= s.charAt(i);
            if(map.containsKey(c) && map.get(c)!=0){
                int freq = map.get(c);
                map.put(c, freq--);
                tLength--;
            }

            while(low<=high && tLength == 0){
                c = s.charAt(low);
                if(maxLength ==-1 || high-low+1< maxLength){
                    maxLength = high-low+1;
                    resultLow = low;
                    resultHigh= high;
                }

                if(map.containsKey(c) && map.get(c)==1){
                    tLength++;
                    int freq = map.getOrDefault(c,0);
                    map.put(c, freq++);
                }
                low++;
            }
            high++;

        }
        return maxLength == -1? "": s.substring(resultLow, resultHigh+1);
    }
}