class Solution {
    public String minWindow(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        if(n > m)
            return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int min = Integer.MAX_VALUE;
        
        String result = "";
        
        for(int i = 0; i < n; i++)
        {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int match = 0;
        int i = 0;
        int j = 0;
        
        while(i <= j && i < s.length())
        {
            if(match == map.size())
            {
                min = Math.min(min, j - i);
                result = s.substring(i,j);
            }
            
            if((i != j && match == map.size()) || j == s.length())
            {
                char c = s.charAt(i);
                if(map.containsKey(c))
                {
                    if(map.get(c) == 0)
                        match--;
                    
                    map.put(c, map.get(c) + 1);
                }
                i++;
            }
            else
            {
                char c = s.charAt(j);
                if(map.containsKey(c))
                {
                    if(map.get(c) == 1)
                        match++;
                    
                    map.put(c, map.get(c) - 1);
                }
                j++;
            }
        }
        
        return result;
    }
}