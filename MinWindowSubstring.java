//space- O(1)
//time - O(n)
class Solution {
    public String minWindow(String s, String t) {
        String res="";
        int matches =0;
        int size = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i< t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1); 
        }
        int j =0;
        int i =0;
        while(i<=j && i<s.length() ){
            //in
            if(matches == map.size()){
              size = Math.min(size,j-i);
              if(size == j-i){
                  res = s.substring(i,j);
              }  
            }
            if((i!=j && matches == map.size() ) || j== s.length()){
                if(map.containsKey(s.charAt(i))){
                    if(map.get(s.charAt(i)) ==0){
                        matches-=1;
                    }
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                }
                i++;
            }else{
                if(map.containsKey(s.charAt(j))){
                    if(map.get(s.charAt(j)) ==1){
                        matches+=1;
                    }
                    map.put(s.charAt(j), map.get(s.charAt(j))-1);
                    
                }
                j++;
            }
               
    }
         return res;    
    }
}