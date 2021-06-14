import java.util.HashMap;

// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        
        if(s.isEmpty() || t.isEmpty() || s==null || t==null)
            return "";
        
        HashMap<Character, Integer> sMap=new HashMap<>();
        for(int i=0;i<t.length();i++)
            sMap.put(t.charAt(i),sMap.getOrDefault(t.charAt(i),0)+1);
        
        int i=0;
        int j=0;
        int count=sMap.size();
        int left=0;
        int right=s.length()-1;
        int min=s.length();
        boolean found=false;
        
        while(j<s.length()){
            char charEnd=s.charAt(j);
            j++;
            if(sMap.containsKey(charEnd)){
                sMap.put(charEnd, sMap.get(charEnd)-1);
                if(sMap.get(charEnd)==0){
                    count--;
                }
            }
            if(count >0)
                continue;
            
            while(count ==0){
              char charstart=s.charAt(i);
                i++;
                if(sMap.containsKey(charstart)){
                sMap.put(charstart, sMap.get(charstart)+1);
                if(sMap.get(charstart) > 0){
                    count++;
                }
            }
                
            }
            
            if(j-i<min){
                left=i;
                right=j;
                min=j-i; 
                found=true;
            } 
        }
        
        if(found)
            return s.substring(left-1,right);
        else
            return "";
    }
}