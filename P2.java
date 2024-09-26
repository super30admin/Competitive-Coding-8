//Time Complexity:O(n+m) n is length of s and m is length of t
//Space Complexity:O(1)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        //setup hashmap for t
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        String res="";
        int i=0,j=0,match=0;
        
        while(i<s.length()){
            char c = s.charAt(i);//in
            if(map.containsKey(c)){
                int count=map.get(c);
                count--;
                map.put(c,count);
                if(count==0) match++;
                }
            while(match==map.size() && j<=i){
                if(res=="" || i-j<res.length()) res=s.substring(j,i+1);//out
                char out =s.charAt(j);
                if(map.containsKey(out)){
                int count=map.get(out);
                count++;
                map.put(out,count);
                if(count==1) match--;  
                }
                j++;
            }
            i++;
        }

        return res;
    }
} 