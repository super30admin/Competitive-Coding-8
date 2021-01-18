// TC: O(N)
//SC: O(N)
class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || s.length() < t.length()) return "";
        
        // String t = "ABC"
        
        HashMap<Character,Integer> map = new HashMap();
        
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        
        int count = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        
        int minLeft = 0;
        
        for(int i = 0 ; i< s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) >= 0){
                count++;
            }
            }
            
            //t = "ABC" 
            while(count == t.length()){
                //eligible window
                
                //length save
                if(minLength > i-start+1){
                    minLength = i-start+1;
                    minLeft = start;
                }
                //remove 
                if(map.containsKey(s.charAt(start))){
                    //NOm
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    //
                    if(map.get(s.charAt(start))>0){
                        count--;
                    }
                }
                start++;
            }
        }
        
        if(minLength > s.length()) return "";
        
        return s.substring(minLeft, minLeft+minLength);
    }
}