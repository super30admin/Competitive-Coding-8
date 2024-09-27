import java.util.*;

public class MinimumWindowSubString {
	
	//TC - o(m+n)
    //SC - o(m+n)
    public String minWindow(String s, String t) {
        
        if(s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";
            
        HashMap<Character,Integer> map = new HashMap<>();
        
        //create a dictionary to check s conatains all characters of t
        for(int i =0; i<t.length();i++){
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int l =0, r =0;
        //store  - length, left and right pointer to the result array for next comparison 
        int [] result = {-1,0,0};
        HashMap<Character,Integer> window = new HashMap<>();
        int match=0;
        //increase right pointer till we traverse the whole string
        while(r<s.length()) {
            char cr = s.charAt(r);
            //put it in a window map for the further process
            window.put(cr,window.getOrDefault(cr,0)+1);
            if(map.containsKey(cr) && window.get(cr).intValue() == map.get(cr).intValue())
                match++;
            
            //if we found all the characters for given window
            //try to reduce the window and check the minimun length needed
            while(l<=r && match == map.size()) {
                //if it is the first time or curr length is less thn the earlier length 
                //update the result array
                if(result[0] == -1 || result[0] > r-l+1) {
                    result[0] = r-l+1;
                    result[1] = l;
                    result[2] = r; 
                }
                char cl = s.charAt(l);
                window.put(cl,window.get(cl)-1);
                //check with each decrement of character we are not removing the needed one
                //if is less thn the needed no of length reduce the match and stop iteration
                if(map.containsKey(cl) && window.get(cl).intValue() < map.get(cl).intValue())
                    match--;
                l++;
            }
            r++;
        }
        return result[0] == -1 ? "" : s.substring(result[1],result[2]+1);
    }

}
