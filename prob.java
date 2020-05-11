//TC:O(n)
//SC:O(1)


class Solution {
    HashMap<Character,Integer> map2;
    HashMap<Character,Integer> map1;
    public String minWindow(String s, String t) 
    {
     if(s.length()<t.length()) return "";
      map2 = new HashMap<>();
      map1 = new HashMap<>();
      int min = Integer.MAX_VALUE;
      int start = 0;
      int end = 0;
      int initial=0;
        int last=0;
      
        for(int i=0;i<t.length();i++)
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        
        for(int i=0;i<t.length();i++)
             map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        
           if(checkvalid())
               return s.substring(0,t.length());
           else
           {
             for(int i=t.length();i<s.length();i++)
             {
                map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
                  while(checkvalid() )
                    {
                      end=i;
                       //System.out.println("valid keyset is "+map1.keySet());
                       //System.out.println("min is "+min);
                       //System.out.println("res is "+(end-start+1));
                      if(min>(end-start+1))
                      {
                          min=(end-start+1);
                          last=i;
                          initial = start;
                         // System.out.println("initial is "+initial);
                      }
                      
                        if(map1.get(s.charAt(start))>1)
                            map1.put(s.charAt(start),map1.get(s.charAt(start))-1);
                        else
                            map1.remove(s.charAt(start));
                      
                         
                          start++; 
                    }
            
              }   
           
           }
       return (min==(Integer.MAX_VALUE) )?"":(s.substring(initial,last+1)) ;
    }
    
    
    public boolean checkvalid()
    {
       for(Character key : map2.keySet())
       {
         if(!(map1.containsKey(key) && map1.get(key)>=map2.get(key)) )  
               return false;
       }
        
      return true;  
    }
    
    
    
    
    
}