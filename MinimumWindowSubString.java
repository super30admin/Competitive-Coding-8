class Solution {
    //Idea is to use sliding window and hashmap to maintain the frequency of characters
    //Time Complexity:O(m+n)
    //Space Complexity:O(1)
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
        {
            return "";
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char ch: t.toCharArray())
        {
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        int count = 0;
        int l = 0, r = 0;
        int mapsize = hm.size();
        int minlength = Integer.MAX_VALUE;
        int lsubstrindex = 0 ,rsubstrindex = 0;
        while(r<s.length())
        {
            char c = s.charAt(r);
            if(hm.containsKey(c))
            {
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0) count++;
            }

            while(l<=r && count == mapsize){
                int currlen = r-l+1;
                if(currlen < minlength) {
                    minlength = currlen;
                    lsubstrindex = l;
                    rsubstrindex = r+1;
                }
                char leftc = s.charAt(l);
                if(hm.containsKey(leftc)){
                    if(hm.get(leftc)==0) count--;
                    hm.put(leftc,hm.get(leftc)+1);
                }
                l++;
            }
            r++;
        }
        return minlength == Integer.MAX_VALUE ? "" : s.substring(lsubstrindex,rsubstrindex);

    }
}
