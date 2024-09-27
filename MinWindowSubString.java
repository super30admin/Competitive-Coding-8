/**
 * Time Complexity : O(s + t) where s is the length of the string 1 and t is length of string 2
 * Space Complexity : O(s + t)
 */
import java.util.*;
public class MinWindowSubString{
    public String minWindow(String s, String t) {
        if(s == null || t == null){return "";}
        int[] ans = {-1,0,0};
        HashMap<Character, Integer> store = new HashMap<>();                                                
        HashMap<Character, Integer> window = new HashMap<>();                                               
        int start =0,  j =0;
        for(int i= 0; i < t.length(); i++){
            store.put(t.charAt(i), store.getOrDefault(t.charAt(i), 0) + 1);                                         
        }
       int match  = 0;
        while(j  < s.length()){
            char c = s.charAt(j);
            window.put(c, window.getOrDefault(c, 0) + 1);                                                       
            if(store.containsKey(c) && store.get(c).intValue() == window.get(c).intValue()){                    
                   match++;                                                                                     
             } 
            while(start <= j && match == store.size()){                        
                if(ans[0] == -1 || ans[0] > j - start + 1){                                                     
                ans[0] = j - start + 1;
                ans[1] = start;                                                                                     
                ans[2] = j;
                }
                c = s.charAt(start);                                                                            
                window.put(c, window.get(c) - 1);                                                                          
                 if(store.containsKey(c) && window.get(c) < store.get(c)){               
                    match--;                                                                                
                }                                                                                   
                start++;                                                                                    
            }
            j++;                                            
            }

        StringBuilder sb = new StringBuilder();
        for(int m = ans[1]; m <= ans[2] ; m++){
            sb.append(s.charAt(m));                                    
        }
        if(ans[0] == -1){
            return "";                                                                                                 
        }                           
        return sb.toString();
    }
}