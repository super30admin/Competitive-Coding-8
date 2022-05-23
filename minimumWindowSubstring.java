//TC: O(m+n) where m is the length of string s and n is length of string t
//SC: O(1) beacuse hashmap can contain upto 128 characters , so it will be constant

//CODE:

class Solution {
    public String minWindow(String s, String t) {
       //null case
         if (s == null || t == null || s.length() < 1 || t.length() < 1 || s.length() < t.length()) {
            return "";
        }
        
        //creating a map of frequencies of all characters in string t
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            int count = map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i),count+1);
        }
        
        int match=0;
        int i=0,j=0;
        int length = Integer.MAX_VALUE;
        int minleft=0;

        while(j<s.length()){
            //incoming character -> if the incoming character is present in map then decrease the frequency of that character and if that frequency becomes 0 , then increase match
            if(match<map.size()){
              char in = s.charAt(j);
            if(map.containsKey(in)){
                int ct = map.get(in);
                ct--;
                map.put(in,ct);
                if(ct ==0) match++;
            }   
            }
            //when match becomes equal to the size of map
            while(match==map.size()){
                //storing the window length and updating our minleft
                if(j-i+1 < length){
                    length = j-i+1;
                    minleft = i;
                }
                //outgoing character -> if the outgoing character exists in map then increase the frequnecy of that character n map and if the frequency becomes 1 then decrease the match
                char outg = s.charAt(i);
                if(map.containsKey(outg)){
                    int ct = map.get(outg);
                    ct++;
                    map.put(outg,ct);
                    if(ct == 1) match--;
                }
                i++;
                
            }
            j++;
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(minleft, minleft + length);  //taking substring from the window
    }
}