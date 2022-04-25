import java.util.HashMap;

//Time Complexity : O(m+n); where m= length of search string 's'and n = length of pattern string 't'
//Space Complexity : O(n)
public class MinWindowSubstring {	
	/**Approach: Sliding Window**/
	public String minWindow(String s, String t) {        
        HashMap<Character, Integer> map= new HashMap<>();
        int start = -1;
        int end = -1;            
        
        //pattern Map
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);            
        }
        
        int match=0; 
        int j=0; //slow pointer      
        for(int i=0; i<s.length(); i++){ //fast pointer
        	//incoming char
            char in= s.charAt(i);
            if(map.containsKey(in)){
                int count=map.get(in) -1;
                if(count==0)  match++;
                map.put(in, count);
            }
            
            //Found the potential window. 
            while(match == map.size()){    
            	//Shrink if better window found
                if(start == -1 || end - start + 1 > i - j + 1){
                    start = j;
                    end = i;
                }	
                //outgoing char
                char out = s.charAt(j);                
                if(map.containsKey(out)){
                	int count=map.get(out)+1;
                    if(count == 1) match--;
                    map.put(out,count);
                }
                j++;//Move left pointer to shrink window within start and end
            }
        }
        
        return start == -1 ? "" : s.substring(start,end+1);        
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		MinWindowSubstring ob= new MinWindowSubstring();
		String s= "ADOBECODEBANC";
		String t= "ABC";
		/*String s= "bdab";
		String t= "ab";*/
		
		System.out.println("Min window substring is: "+ob.minWindow(s, t));					
	}	
}
