// TC : O(|T| +|S|)
// SC: O(1)  constant space for map with upper bound to 256
public class minimumWindowSubstring {

	public String minimumWindow(String s, String t) {
		
		int[] map = new int[256];
		for(int i=0;i<t.length();i++) {
			map[t.charAt(i)-'A']++;
		}

		int st = 0, end = 0, head = 0, minLen = Integer.MAX_VALUE;
		int cnt = t.length();
		
		while(end < s.length()) {
		
			if(map[s.charAt(end)-'A'] > 0) cnt --;  // if the value is present in map, decrement the count to show that we have already visited the character in S string
			map[s.charAt(end)-'A']--; // already visited
			end++; // move ahead with end
			while(cnt == 0) {  // if the count is 0, means we have found the string which has all characters of T in S
				if(minLen > end - st) {   // if the length is less than already present length, we update the length
					minLen = end - st;  // end - start will give us the length of substring which has all characters in S
					head = st; // update our head which will be used to retrieve the substring
				}
				// since we remove that character count from the substring, we will update our result 
				if(map[s.charAt(st)-'A'] == 0) cnt++;
				map[s.charAt(st)-'A']++;
				st++;
			}
		}
		
		return minLen == Integer.MAX_VALUE? "": s.substring(head, head+minLen);
	}
}
