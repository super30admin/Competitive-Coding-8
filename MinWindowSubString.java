// Time Complexity : O(N)
// Space Complexity : O(t)
// Did this code successfully run on Leetcode : Yes. 
// Any problem you faced while coding this : (TLE for 1 test case)


// Your code here along with comments explaining your approach
class MinWindowSubString {
        public String minWindow(String s, String t) {
        if(t.length() > s.length() || s.length() == 0 || t.length() == 0){return "";}
        Map<Character,Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        int count = tMap.size();
        Map<Character,Integer> sMap = new HashMap<>();
        int left = 0, right = 0;
        Integer leftIndex = null, rightIndex = null;
        while(right < s.length()){
            System.out.println(count +" " +sMap);
            char ch = s.charAt(right);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            if(tMap.containsKey(ch) && sMap.containsKey(ch) && tMap.get(ch) == sMap.get(ch)){
                count--;
            }
            while(count == 0 && left <= right){
                if(leftIndex == null ||  rightIndex - leftIndex > right - left){
                    rightIndex = right;
                    leftIndex = left;
                }
                char ch1 = s.charAt(left);
                sMap.put(ch1,sMap.get(ch1)-1);
                if(tMap.containsKey(ch1) && sMap.containsKey(ch1) && tMap.get(ch1) == sMap.get(ch1)+1){
                    count++;
                }
                left++;
            }
            right++;
        }
    return leftIndex == null ? "":s.substring(leftIndex,rightIndex+1);
    }
}