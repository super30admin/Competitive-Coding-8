package CompetitiveCoding8;
//TC : o(s+t), length of two strings
//SC : o(s+t)
public class MinimumWindowSubstring {
	class Solution {
	    public String minWindow(String s, String t) {
	        if(s.length() == 0 || t.length() == 0) return "";
	        HashMap<Character, Integer> tmap = new HashMap<>();
	        for(int i=0;i<t.length();i++){
	            char c = t.charAt(i);
	            tmap.put(c, tmap.getOrDefault(c,0)+1);
	        }
	        int windowSize = tmap.size();
	        int l=0;
	        int r=0;
	        int window =0;
	        int[] res = new int[]{-1,0,0};
	        HashMap<Character,Integer> smap = new HashMap<>();
	        while(r<s.length()){
	            char c = s.charAt(r);
	            smap.put(c, smap.getOrDefault(c,0)+1);
	            
	            if(tmap.containsKey(c) && smap.get(c).intValue() == tmap.get(c).intValue()){
	                window++;
	            }
	            while(l<=r && window == windowSize){
	                c = s.charAt(l);
	                if(res[0] == -1 || res[0] > r-l+1){
	                    res[0] = r-l+1;
	                    res[1] = l;
	                    res[2] = r;
	                }
	                smap.put(c, smap.get(c)-1);
	            if(tmap.containsKey(c) && smap.get(c).intValue() < tmap.get(c).intValue()){
	                window--;
	            }
	                l++;    
	            }
	            r++;
	        }
	        return res[0] == -1 ? "" : s.substring(res[1], res[2]+1);
	    }
	}
}
