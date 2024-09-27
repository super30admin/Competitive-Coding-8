//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()==0 ||t.length()==0||s.length()<t.length())
            return "";
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
            
        }
        int match=0;
        int temp=Integer.MAX_VALUE;
        int i=0,j=0;
        String output="";
        while(i<=j && i<s.length()){
            if(match==map.size()){
                temp=Math.min(temp,j-i);
                if(temp==j-i){
                    output=s.substring(i,j);
                }
            }
            if(i!=j && match==map.size() || j==s.length()){
                char out=s.charAt(i);
                if(map.containsKey(out)){
                    if(map.get(out)==0)
                        match--;
                    map.put(out,map.getOrDefault(out,0)+1);
                }
            i++;
            }else{
                char in=s.charAt(j);
                if(map.containsKey(in)){
                    if(map.get(in)==1){
                        match++;
                    }
                    map.put(in,map.get(in)-1);
                }
            j++;
            }
        }
        return output;
    }
}
