// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int compress(char[] chars) {
        
        if(chars.length==0) return 0;
	    int ans = 0;
	    int count = 1;
	    char curr = chars[0];
	    
	    // iterate over String
	    for(int i=1;i<chars.length;i++) {
	        
	        // if ch[i]!=ch[i-1] add ch + count to output string and set ch t0 curr char and c to 1
	        if(chars[i]!=curr) {
                
                chars[ans]=curr;
	            ans++;
	            if(count>1) {
                    
                    String t = ""+count;
                    for(char c : t.toCharArray()) {
                        chars[ans] = c;
                        ans++;
                    }
                    
                    
                }
	            
	            count=1;
	            curr = chars[i];
                
	        } else {
                
	            count++;
                
	        }
	    }
        
	    chars[ans]=curr;
	    ans++;
	    if(count>1) {
            String t = ""+count;
            for(char c : t.toCharArray()) {
                chars[ans] = c;
                ans++;
            }
        }
        
	    return ans;
    }
}
