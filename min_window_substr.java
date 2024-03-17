//TC: O(m)
//SC: O(1)
class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        int length=Integer.MAX_VALUE;
        String result="";
        HashMap<Character,Integer> map=new HashMap<>();
        int m_count=0;
      int low=0;
      int high=0;
        for(int i=0;i<n;i++)
        {
            char c=t.charAt(i);
            if(!map.containsKey(c))
            map.put(c,1);
            else
            {
                int count=map.get(c);
                map.put(c,count+1);
            }
        }
       while(low<=high)
      {
         char c=s.charAt(high);
         if(map.containsKey(c))
         {
          
            int count=map.get(c);
            map.put(c,count-1);
            if(count-1==0)
            m_count++;
         }
        //  if(m_count<map.size()&&high+1<m)
        //  {
        //        high++;

        //  }
         if(m_count==map.size())
         {
            String temp=s.substring(low,high+1);
            System.out.println(temp);
            if(temp.length()<length)
            {
                length=temp.length();
                result =String.copyValueOf(temp.toCharArray());
            }
            char e=s.charAt(low);
            if(map.containsKey(e))
            {
                int r=map.get(e);
                map.put(e,r+1);
                if(r+1==1)
                  m_count--;    
                
                if(high == m-1){
                    break;
                }
            }
            low++;
         }
        if(high+1<m){
            high++;
        }
      }
      return result;
    }

}