// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;

public class Minimum_window_substring {
	 public String minWindow(String s, String t) {
	        HashMap<Character,Integer> map=new HashMap<>();
	        for(int i=0;i<t.length();i++){
	            char c=t.charAt(i);
	            if(!map.containsKey(c)){
	                map.put(c,0);
	            }
	            map.put(c,map.get(c)+1);
	        }
	        int count=0;
	        int j=0;
	        String result="";
	        int min=Integer.MAX_VALUE;
	        int i=0;
	        while(i<=j && i<s.length()){
	            
	             if(count==map.size()){
	                if(j-i<min){
	                    result=s.substring(i,j);
	                    min=result.length();
	                }
	            }
	            
	         if((i!=j && count==map.size()) || j==s.length()){
	             char c=s.charAt(i);
	             if(map.containsKey(c)){
	                 if(map.get(c)==0) count--;
	                 map.put(c,map.get(c)+1);
	             }
	             i++;
	         }else{
	                char c=s.charAt(j);
	                if(map.containsKey(c)){
	                    map.put(c,map.get(c)-1);
	            
	                if(map.get(c)==0){
	                    count++;
	                }
	                    
	                }
	                j++;
	            }
	               
	        }
	        
	        return result;
	    }
}
