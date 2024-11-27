/*We start with two pointers, left and right initially pointing to the first element of the string S.

step 2 :We use the right pointer to expand the window until we get a desirable window i.e. a window that contains all of the characters of T.

Once we have a window with all the characters, we can move the left pointer ahead one by one. If the window is still a desirable one we keep on updating the minimum window size.

If the window is not desirable any more, we repeat step2 onwards.
*/
//Time Complexity: O(|S| + |T|)O(∣S∣+∣T∣) where |S| and |T| represent the lengths of strings SS and TT. In the worst case we might end up visiting every element of string SS twice, once by left pointer and once by right pointer. |T|∣T∣ represents the length of string TT.
//
//Space Complexity: O(|S| + |T|)O(∣S∣+∣T∣). |S|∣S∣ when the window size is equal to the entire string SS. |T|∣T∣ when TT has all unique characters. 

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	    public String minWindow(String s, String t) {
	      if (s.length() == 0 || t.length() == 0) {
	          return "";
	      }
	      
	      //put pattern string in map with key ass character and value as no of occurances
	        HashMap<Character,Integer> map = new HashMap<>();
	        for(int i =0; i<t.length();i++){
	             int count = map.getOrDefault(t.charAt(i), 0);
	          map.put(t.charAt(i), count + 1);
	        }
	        
	        // matching is used to keep track of how many unique characters in t
	        // are present in the current window in its desired frequency.
	        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
	        // Thus formed would be = 3 when all these conditions are met.
	        int matching =0;
	        int requiredSize =map.size();
	        
	        // ans list of the form (window length, left, right) 
	        //save smallest window
	        int[] ans ={-1,0,0};
	        int r =0;
	        int l=0;
	        HashMap<Character,Integer> windowMap = new HashMap<>();
	        
	        //two pinters
	        while(r<s.length()){
	             int count = windowMap.getOrDefault(s.charAt(r), 0);
	             
	             //store window characters and no of occurances in map
	             windowMap.put(s.charAt(r), count + 1);
	            if(map.containsKey(s.charAt(r)) && windowMap.get(s.charAt(r)).intValue()==map.get(s.charAt(r)).intValue()){
	                matching++;
	            }
	            while(l<=r && matching == requiredSize ){
	                char c = s.charAt(l);
	              // Save the smallest window until now.
	              if (ans[0] == -1 || r - l + 1 < ans[0]) {
	                  ans[0] = r - l + 1;
	                  ans[1] = l;
	                  ans[2] = r;
	              }
	            windowMap.put(c,windowMap.get(c)-1); //we r incrementing i so remove outgoing character
	             if(map.containsKey(c) && windowMap.get(c).intValue()<map.get(c).intValue()){
	                   matching--;
	            }
	             // Move the left pointer ahead, this would help to look for a new window.
	                     l++;
	         }
	            // Keep expanding the window once we are done contracting.           
	            r++;    
	    }
	               System.out.println(s.substring(ans[1], ans[2] + 1));       
	      return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	    }
	}	

