class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int n1=t.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n1;i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int left=0;
        int cnt=0;
        int st=0;
        int mini=Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            if(map.containsKey(c)){
                int res=map.get(c);
                map.put(c,res-1);
                if(map.get(c)>=0){
                    cnt++;
                }
            }
            while(cnt==n1){
                if(r-left+1<mini){
                mini=r-left+1;
                st=left;
                }
                char cp=s.charAt(left);
                if(map.containsKey(cp)){
                    map.put(cp,map.get(cp)+1);
                    if(map.get(cp)>0){
                        cnt--;
                    }
                }
                left++;
            }
        }
        if(mini==Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(st,st+mini);
        }
    }
}
