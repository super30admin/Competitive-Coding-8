// Time Complexity : O(2n) once for i and once for j
// Space Complexity : O(1) // hashmap + auxillary data
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
        /* Edge case */
        if(s==null || s.length()==0 || t==null || t.length()==0)
            return "";
        
        int minLeft=0;
        int minRight=0;
        int minSize=Integer.MAX_VALUE;
        
        int i=0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        /* Go over T build hashmap */
        for(char c : t.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        
        int count=map.size();
        
        /* Go over S */
        
        for(int j=0;j<s.length();j++)
        {
            //System.out.println(i+" "+j);
            char c=s.charAt(j);
            /* Check if the current character is map */
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    count--;
            }
            
            /* Check within same substring */
            
            while(i<=j && count==0)
            {
                
                if(count==0)
                {
                    int size=j-i+1;
                    if(size<minSize)
                    {
                      minLeft=i;
                      minRight=j+1;
                      minSize=size;
                    }
                }
                
                char leftCharacter=s.charAt(i);
                if(map.containsKey(leftCharacter))
                {
                    map.put(leftCharacter,map.get(leftCharacter)+1);
                    if(map.get(leftCharacter)>0)
                        count++;
                }
                i++;    
            }
        }
        
        return (minLeft==0 && minRight==0)?"":s.substring(minLeft,minRight);
    }
}