
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String s="ADOBECAB"; String t = "ABC";
            
        String k = minimumWindow(s,t);
        System.out.println(k);
    }
    public static String minimumWindow(String s, String t) {
    //Sanity Check
    if(s.length() == 0 || s.length() == 0 || s.length() < t.length() )
        return "";
    //hashmap for String T
    HashMap<Character , Integer> hashmap = new HashMap<Character,Integer>();
    for(char ch : t.toCharArray())
        hashmap.put(ch,hashmap.getOrDefault(ch,0)+1);
    
    int start = 0;//1st pointer
    int min = 0;//min start pointer,minWindow length && counter to maintain the window length
    int minWindow = Integer.MAX_VALUE; int counter = 0;
    //Length of main string
    int len = s.length();
    for(int end = 0; end < len; end++){
        char ch = s.charAt(end);
        if(hashmap.containsKey(ch)){
            hashmap.put(ch,hashmap.get(ch)-1);
            if(hashmap.get(ch) >= 0)
                counter ++;
            //check if we have found all the characters of t in this window
            while(counter == t.length()){
                // check if this is the minimum window length
                if(end-start+1 < minWindow){
                    min = start;//record start pointer, minWindow length gets updated
                    minWindow = end-start+1;}
                //contract the window , restore the hashmap from start pointer
                ch = s.charAt(start);
                if(hashmap.containsKey(ch)){
                    hashmap.put(ch,hashmap.get(ch)+1);
                    if(hashmap.get(ch) > 0)
                        counter --;}
                //Increment start pointer
                start ++ ;}
        }
    }//for loop ends here
    if(minWindow > len)  
    //then return empty string 
        return "";  
     
    //return the string with window from min start pointer 
    return s.substring(min,min+minWindow);
    }

}