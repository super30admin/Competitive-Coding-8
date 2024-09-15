

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, quite complex


// Your code here along with comments explaining your approach
/*Approach
1) we use a hashmap and store the occurrences of characters of t in map
2) we apply sliding window technique on String s
3) we begin with 3 pointers ->
                        1) begin
                        2) end
                        3) head
4) we use counter to calculate the map size
5) we increase the end pointer with each incoming character
6) whenever we encounter the character and check in map, if it exists then we decrease the occurence of the character from map and if the count of character in map os 0 we decrement the counter as well
7) when counter ==0
-> we begin to increase the begin pointer
and also increase the counter value
-> if(map.get(temp)>0)
        counter++;
8) if(end-begin<len)
                {
                    len=end-begin;
                    head=begin;
                }
    used to reset the head which will give us the length of the substring 
    s.substring(head,head+len);
                    

*/



import java.util.*;
class MinWindowSubstring {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        
        for(char c: t.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int begin=0, end=0, len=Integer.MAX_VALUE,head=0;
        
        int counter=map.size();
        
        while(end<s.length())
        {
            char c = s.charAt(end);
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    counter--;
            }
            
            end++;
            
            while(counter==0)
            {
                char temp = s.charAt(begin);
                if(map.containsKey(temp))
                {
                    map.put(temp,map.get(temp)+1);
                    if(map.get(temp)>0)
                        counter++;
                    
                }
                
                
                if(end-begin<len)
                {
                    len=end-begin;
                    head=begin;
                }
            
                begin++;
                
            }
            
            
            
            
        }
        
        /*for(Map<Character,Integer> maps :map.keySet())
        {
            String key = maps.toString();
            int value = maps.get(Key).toString();  
            System.out.println(key + " " + value);  
        }*/
        
    //    System.out.println(""+map.entrySet());
        
        
       if(len==Integer.MAX_VALUE)
           return "";
        else
            return s.substring(head,head+len);
        
        
        
    }
}