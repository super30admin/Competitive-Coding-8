//time complexity: O(m+n)

class Solution {
    public String minWindow(String s, String t)
    {
            if(s.length() < t.length())
            {
                return "";
            }
    
    
    int[] tMap = new int[256];
    int[] sMap = new int[256];
        
     int start =0;
     int count = 0;
    int ptr =-1;
    
    int minLen =Integer.MAX_VALUE;
    
    for(int i =0 ;i < t.length();i++)
    {
        tMap[t.charAt(i)]++;
  
    }
        
       
        
     for(int end = 0 ; end < s.length();end++)
     {
         sMap[s.charAt(end)]++;
         
         if(sMap[s.charAt(end)] <= tMap[s.charAt(end)] && tMap[s.charAt(end)] != 0)
         {
             count++;
         }
         
         if(count == t.length())
         {
             //perform filtering by removing unwanted chars by shrinnking the window
             
             while(sMap[s.charAt(start)] > tMap[s.charAt(start)] || tMap[s.charAt(start)] == 0)
             {
                 if(sMap[s.charAt(start)] > tMap[s.charAt(start)])
                 {
                     sMap[s.charAt(start)]--;
                     
                 }
                 start++;
             }
             
             int currLen = end - start+1;
             if(minLen > currLen)
             {
                 
                 minLen = currLen;
                 ptr = start;
             }
             
         }
     }
    

        if(ptr == -1)
        {
            return "";
        }
        
        return s.substring(ptr, ptr + minLen);
        

    
 }
    
}