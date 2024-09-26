//time complexity : O(s.length() + t.length())
//space complexity : O(1)
//executed on leetcode : yes

class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if(s==null || t==null || t.length()>s.length()) return result;
        int min=Integer.MAX_VALUE;
        int left = 0;
        int count = 0;
        int[] lcount = new int[128];
        for(char c: t.toCharArray()) ++lcount[c];
        for(int right = 0;right<s.length();++right)
        {
            if(--lcount[s.charAt(right)]>=0) count++; //curr char is present in t string
            while(count==t.length())
            {
                if(min>right-left+1)
                {
                    min = right-left+1;
                    result = s.substring(left,right+1);
                }
                if(++lcount[s.charAt(left)]>0) count--;
                left++;
            }
        }
        return result;
    }
}