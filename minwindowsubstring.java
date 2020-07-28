//Time complexity:O(m+n) 
//Space complexity:O(m+n)

class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap();
        Map<Character,Integer> window=new HashMap();
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int start=0;
        int end=0;
        int match=0;
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(i<s.length()){
            char c=s.charAt(i);
            window.put(c,window.getOrDefault(c,0)+1);
            if(map.containsKey(c) && map.get(c).intValue()==window.get(c).intValue()){
                 match++;
            }
            while(j<=i && match==map.size()){
                if(i-j+1 < min){
                    min=i-j+1;
                    start=j;
                    end=i;
                }
                c=s.charAt(j);
                window.put(c,window.getOrDefault(c,0)-1);
                if(map.containsKey(c) && map.get(c).intValue()>window.get(c).intValue()){
                    match--;
                }
                j++;
            }
            i++;
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,end+1);
    }
}