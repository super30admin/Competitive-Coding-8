//Time Complexity : O(m+n)
//Space Complexity : O(1)
class Solution {
    public String minWindow(String s, String t) {
        String resultString= "";
        if(t.length() > s.length()){
            return resultString;
        }
        int[] tCount = new int[128];
        for(char ch : t.toCharArray()){
            tCount[ch]++;
        }

        char[] sChars= s.toCharArray();
        int left=0;
        int right=0;
        int found=0;
        int toFind = t.length();
        int minWindowLength = Integer.MAX_VALUE;
        while(right < s.length()){
            char ch = sChars[right];
            tCount[ch] --;
            if(tCount[ch] >=0){
                found++;
            }
            while(found == toFind){
                if(minWindowLength > (right - left+1)){
                    minWindowLength = right - left + 1;
                    resultString = s.substring(left, right + 1);
                }
                tCount[sChars[left]]++;
                if(tCount[sChars[left]] > 0){
                    found--;
                }
                left++;
            }
            right++;
        }
        return resultString;
    }
}
