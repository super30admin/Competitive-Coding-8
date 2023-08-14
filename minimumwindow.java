// TC : O(m+n)
// SC : O(1)

class Solution {
    public String minWindow(String s, String t) {
        if((s==null && t==null) || (s.length()==0 && t.length()==0)) return "";
         
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        int slow=0;
        int fast = 0;
        int match = 0;
        
        while(slow<=fast && slow<s.length()){
            if(match==map.size()){
                if(sb.length()!=0 && sb.length()>fast-slow){
                    sb = new StringBuilder(s.substring(slow,fast));
                }
                else if(sb.length()==0){
                    sb = new StringBuilder(s.substring(slow,fast));
                }
            }
            
            if(slow!=fast && match == map.size() || fast==s.length()){
                if(map.containsKey(s.charAt(slow))){
                    int count = map.get(s.charAt(slow));
                    count++;
                    if(count==1){
                        match--;
                    }
                    map.put(s.charAt(slow),count);
                }
                   slow++;
                   
            }
        
                   else{
                       if(map.containsKey(s.charAt(fast))){
                           int count = map.get(s.charAt(fast));
                           count--;
                           if(count==0){
                               match++;
                           }
                           map.put(s.charAt(fast),count);
                       }
                       fast++;
                   }
        }
           return sb.toString();
    }
}