//Time complexity:- O(m + n)
//Space complexity:- O(1)
class Solution {
    public String minWindow(String s, String t) {

        int m = s.length();
        int n = t.length();
        
        //Count the frequency of characters in t
        Map<Character, Integer> count = new HashMap<>();
        for(char ch: t.toCharArray()) {

            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        //number of unique letters in t
        int required = count.size();

        //we will use sliding windows to go over each characters and count the frequency of characters. If the number of char and their frequency is equal to t then save the window
        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0;
        int right = 0;
        
        //number of letters found in a windows
        int formed = 0;

        //saving the window :- a[0] = length, a[1] = left, a[2] = right
        int a[] = {-1, 0, 0};
        
        //window from left to right
        while(right < m) {

            char in = s.charAt(right);
            windowCount.put(in, windowCount.getOrDefault(in, 0) + 1);

            //1 letter formed in window
            if(count.containsKey(in) && count.get(in).intValue() == windowCount.get(in).intValue()) {
                formed++;
            }

            //if all the letters are formed then save the window
            while(left <= right && required == formed) {

                if(a[0] == -1 || a[0] > (right - left + 1)) {

                    a[0] = right - left + 1;
                    a[1] = left;
                    a[2] = right;
                } 

                //reduce size of window
                char out = s.charAt(left);

                //if the outgoing character is part of t
                if(count.containsKey(out) && windowCount.get(out).intValue() == count.get(out).intValue())
                    formed--;

                windowCount.put(out, windowCount.get(out) - 1);
                left++;
            }

            right++;
        }

        return a[0] == -1 ? "": s.substring(a[1], a[2] + 1); 
    }
}