//TC: O(2n), where n is the length of string s
//SC: O(m), m is the no of unique chars in t

class Solution {
    public String minWindow(String s, String t) {

        int n=s.length();

        int range=Integer.MAX_VALUE, match=0;

        int res[]=new int[]{-1,-1};

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c= t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int size=map.size();

        int l=0;

        for(int r=0;r<n;r++){

            char in=s.charAt(r); //incoming char

            if(map.containsKey(in)){

                int fr=map.get(in);
                fr--;

                map.put(in,fr);

                if(fr==0){  //matched one char completely with/without duplicates
                    match++;
                }
            }

            while(match==size){  //all characters in target matched with map size

                if((r-l+1) < range){
                    range=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                char out=s.charAt(l);

                if(map.containsKey(out)){
                    int fr=map.get(out);
                    fr++;
                    map.put(out,fr);

                    if(fr==1)
                        match--;
                }
                l++;
            }

        }
        return range==Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);

    }
}