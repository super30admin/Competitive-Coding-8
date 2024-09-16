// Time Complexity : O(m + n), length of strings s and t
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
public class Minimum_Window_Substring {
	public String minWindow(String s, String t) {
		if(s.length() == 0 || t.length() == 0)
			return "";

		//map to keep count of all the characters of string t
		HashMap<Character, Integer> mapT = new HashMap<>();
		for(int i=0; i<t.length(); i++){
			int count = mapT.getOrDefault(t.charAt(i), 0);
			mapT.put(t.charAt(i), count + 1);
		}

		// number of unique characters in t, which needs to be present in the desired window
		int required = mapT.size();
		int left = 0; int right = 0;

		/* formed is used to keep track of how many unique characters in t
        are present in the current window in its desired frequency.
        e.g. if t is "AABC" then the window must have two A's, one B and one C.
        Thus formed would be = 3 when all these conditions are met */
		int formed = 0;

		//map which keeps count of all characters in the current window of string s
		HashMap<Character, Integer> mapS = new HashMap<>();
		// answer list of the form
		int[] ans = {-1, 0, 0}; //(window length, left, right)
		while(right < s.length()){
			char c = s.charAt(right);
			int count = mapS.getOrDefault(c, 0);
			mapS.put(c, count + 1);

			/*if the frequency of the current character added is equal to the desired
            count in t, then increment the formed count by 1*/
			if(mapT.containsKey(c) && mapS.get(c).intValue() == mapT.get(c).intValue()){
				formed++;
			}
			//try till the point where window is desired
			while(left <= right && formed == required){
				c = s.charAt(left);
				//save the small window til now
				if(ans[0] == -1 || right - left + 1 < ans[0]){
					ans[0] = right - left + 1;
					ans[1] = left;
					ans[2] = right;
				}
				//The character at the position pointed by the `Left` pointer is no longer a part of the window.
				c = s.charAt(left);
				mapS.put(c, mapS.get(c) -1);

				if(mapT.containsKey(c) && mapS.get(c).intValue() < mapT.get(c).intValue()){
					formed--;
				}

				// move the left pointer ahead
				left++;
			}
			right++;    //move right pointer till we find a match
		}
		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}
}
