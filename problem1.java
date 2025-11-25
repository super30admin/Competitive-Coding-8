// Time Complexity : O(m+n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

/*
Approach
first we make the hash map of string "t" then 
then we take count of the size of the map( this will help us keep track weither we have found all the elements of the map in the substring or not)
as we have to find the smallest substring we take a minLen var as we might encounter many substring containing all the
element of "t" 

start the loop on "s" keep decrasing the count of chars in map if the count hits 0 of a particular node decrease the count

if count ==0 meaning we have found all elements of the map now start reducing the length of the substring from left using a i pointer
while reducing  the size keep reducing the increase the value of the key in the map if an key's value becomes 1 increase the count by one as well
and store the minlen and that substring value before the count became 1

repeeat the process until you reach the end of the loop
in the end you will have the smallest size and substring

*/

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> Tmap = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            char ch = t.charAt(k);
            Tmap.put(ch, Tmap.getOrDefault(ch, 0) + 1);
        }
        int count = Tmap.size();
        int i = 0;
        String result = "";
        int minLen = Integer.MAX_VALUE;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (Tmap.containsKey(ch)) {
                int value = Tmap.get(ch);
                Tmap.put(ch, --value);
                if (value == 0) {
                    count--;
                }
            }
            while (count == 0) {
                char leftSideCH = s.charAt(i);
                if (Tmap.containsKey(leftSideCH)) {
                    int value = Tmap.get(leftSideCH);
                    Tmap.put(leftSideCH, ++value);
                    if (value > 0) {
                        if (j - i + 1 < minLen) {
                            minLen = j - i + 1;
                            result = s.substring(i, j + 1);
                        }
                        count++;
                    }
                }
                i++;
            }

        }
        return result;
    }
}