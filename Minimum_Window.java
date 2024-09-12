
// Time Complexity :O(N+M)
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character,Integer> map = new HashMap<>();
        char[] t1 = t.toCharArray();
        for(char ch:t1){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> visited = new HashMap<>();
        char[] s1 = s.toCharArray();
        
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start=0;
        int end=0;
        int i = 0;
        int j = 0;
        while(i<s1.length && j<s1.length){
            char ch2=s1[j];
            
            visited.put(ch2,visited.getOrDefault(ch2,0)+1);
            if(map.containsKey(ch2) && (map.get(ch2)>=visited.get(ch2))){
                count++;
            }
            
            while(count==t1.length){  
                if(minLen>j-i+1){
                    start=i;
                    end=j;
                }
                minLen = Math.min(minLen,j-i+1);
                char ch1=s1[i];
                visited.put(ch1,visited.getOrDefault(ch1,0)-1);
                if(map.containsKey(ch1) && (map.get(ch1)>visited.get(ch1))){
                    count--;
                }
                if(visited.get(ch1)==0){
                    visited.remove(ch1);
                }
                i++;
            }
            j++;
        }
        
        return minLen>s.length()?"":s.substring(start,end+1);
    }
}