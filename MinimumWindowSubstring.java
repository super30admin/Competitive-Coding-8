// Time Complexity : O(s+t) where s- length of string s, t - length of string t
// Space Complexity : O(s+t) where atmost use HashMap to store elements of s or t
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
        int start =0,res=Integer.MAX_VALUE, count =0;
        String result ="";
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++)
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0)
                    count++;
            }
            while(count == map.size()){
                if(res > i-start+1){
                    res = i-start+1;
                    result = s.substring(start,i+1);
                }
                if(map.containsKey(s.charAt(start))){
                    if(map.get(s.charAt(start)) == 0)
                        count--;
                    map.put(s.charAt(start),map.get(s.charAt(start))+1);
                }
                start++;
            }
        }
        return result;
    }
}
