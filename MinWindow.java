class Solution 
{
    public String minWindow(String s, String t) 
    {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(char ch: t.toCharArray())
        {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
            
        
        int i = 0;
        int j = 0;
        
        int length = s.length();
        int patternLength = t.length();
        int resultLength = map.size();
        
        String output = s;
        boolean found = false;
        
        
        while(j < length)
        {
            char incoming = s.charAt(j++);
            
            if(map.containsKey(incoming))
            {
                int count = map.get(incoming);
                count--;
                
                map.put(incoming,count);
                
                if(count == 0)
                    resultLength--;
                
                if(resultLength > 0)
                    continue;
                
                while(resultLength == 0)
                {
                    found = true;
                    int currentLength = j - i;
                    if(currentLength < output.length())
                        output = s.substring(i, j);
                    
                    char outgoing = s.charAt(i++);
                    if(map.containsKey(outgoing))
                    {
                        count = map.get(outgoing);
                        count++;
                    
                        map.put(outgoing, count);
                        if(count ==1)
                            resultLength++;
                    } 
                }    
            }
            
        }
        
        return found ? output : "";
    }
}