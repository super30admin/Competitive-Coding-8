class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int slow=0;
        int fast=0;
        int match=0;
        String res="";
        while(fast<s.length()){
            char in = s.charAt(fast);
            if(map.containsKey(in)){
                map.put(in,map.get(in)-1);
                if(map.get(in)==0){
                    match++;
                    
                }
            }
            while(match==map.size()){
                if(res.length()==0 || res.length()>fast-slow+1){
                    res=s.substring(slow,fast+1);
                }

                char out=s.charAt(slow);
                if(map.containsKey(out)){
                    map.put(out,map.get(out)+1);
                        if(map.get(out)>0){
                            match--;
                        }
                        
                }
                
                slow++;               
            }
            fast++;
        }
        
        return res;
    }
}
