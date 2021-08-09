// Time Complexity :O(s+t)
// Space Complexity :O(s+t)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach-
class Solution {
    public String minWindow(String s, String t) {
        if(t.length()== 0 || s.length()== 0)
             return "";
        HashMap<Character,Integer> orig= new HashMap<>();
        for (int i=0;i<t.length();i++){
            orig.put(t.charAt(i),orig.getOrDefault(t.charAt(i),0)+1);//adding the t string into map
        }
        HashMap<Character,Integer> window= new HashMap<>();
        int req=orig.size();
        int formed=0;
        int start=0;
        int end=0;
        int len=-1;
        int[] ans= new int[]{len,start,end};
        while(end<s.length()){
           
            char ch= s.charAt(end);
            window.put(ch,window.getOrDefault(ch,0)+1);
            if(orig.containsKey(ch) && window.get(ch).intValue()==orig.get(ch).intValue()){//if char in original map then increase formed 
                formed++;
            }
            while(start<=end && formed==req){
                //System.out.println(formed+"second loop");
                ch=s.charAt(start);
                if(ans[0]==-1 || end-start+1<ans[0]){
                    ans[0]=end-start+1;
                    ans[1]=start;
                    ans[2]=end;
                }
                
                window.put(ch,window.get(ch)-1);
                if(orig.containsKey(ch) && window.get(ch).intValue()<orig.get(ch).intValue()){
                    formed--;
                }
                start++;
            }
            end++;
        }
      
        
        return (ans[0]==-1)?"":s.substring(ans[1],ans[2]+1);
        
    }
}