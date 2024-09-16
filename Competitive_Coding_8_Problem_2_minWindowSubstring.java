import java.util.HashMap;
//Time complexity : O(n) We'll be traversing through the string
//Space complexity : O(n) length of the string we need to find
//Runs successfully on leetcode
//No problem

//Here we will be adding characters of the string we need to find in hashmap with frequency
//We'll be having two pointers, in the begining one pointer will stay at the begining of the string and other will go ahead
//After we find all the elements we need, we will move the first pointer and check if any smaller string can get the same result



public class Competitive_Coding_8_Problem_2_minWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
    else if(t.length() > s.length()) return "";
        HashMap<Character,Integer> hmt = new HashMap<>();
        for(char c : t.toCharArray())
        {
            hmt.put(c,hmt.getOrDefault(c,0)+1);
        }
        int start = 0;
        int end = s.length()-1;
        int tot = Integer.MAX_VALUE;
        int required = t.length();
        int left = 0;
        int right = 0;
        int formed = 0;
        while(right<s.length())
        {
            char c = s.charAt(right);
            if(hmt.containsKey(c))
            {
                hmt.put(c,hmt.get(c)-1);
                if(hmt.get(c) >= 0)
                {
                    formed++;
                }
            }
            while(left <= right && formed == required)
            {
                if(end - start + 1 >= right - left +1)
                {
                    end = right;
                    start = left;
                    tot = end - start +1;
                }
                char ch = s.charAt(left);
                if(hmt.containsKey(ch))
                {
                    hmt.put(ch,hmt.get(ch)+1);
                    if(hmt.get(ch)>=1)
                    {
                        formed--;
                    }
                }
                left++;
            }
            right++;
        }
        if(tot == Integer.MAX_VALUE)
        {
            return "";
        }
        else
        {
            return s.substring(start,end+1);
        }
    }

}
