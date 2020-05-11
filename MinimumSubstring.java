class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> characterCount =  new HashMap<>();
        for(Character c : t.toCharArray())
        {
            characterCount.put(c,characterCount.getOrDefault(c,0)+1);
        }
        
        int required = characterCount.size();
        
        int formed = 0;
        int min = -1 ;
        int left = 0;
        int right = 0;
        
        int l=0,r=0;
        HashMap<Character,Integer> currentWindow =  new HashMap<>();
        while(r<s.length())
        {
            Character c= s.charAt(r);
            currentWindow.put(c,currentWindow.getOrDefault(c,0)+1);
            if(characterCount.containsKey(c) && currentWindow.get(c)==characterCount.get(c))
            {
                formed++;
            }
            
            while(l<=r && formed == required)
            {
                Character ct = s.charAt(l);
                if(min ==-1 || r-l+1 < min)
                {
                    min = r-l+1;
                    left = l;
                    right = r;
                }
                currentWindow.put(ct,currentWindow.getOrDefault(ct,0)-1);
                         if(characterCount.containsKey(ct) && currentWindow.get(ct)<characterCount.get(ct))
            {
                formed--;
            }
                l++;
            }
            r++;
        }
        System.out.println(min+" "+left+" "+right);
        return min == -1? "" : s.substring(left,right+1);
    }
}