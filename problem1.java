import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Time Complexity: O(S+ T)
//Space Complexity: O(S + T)
public class problem1 {
    public String minWindow(String s, String t) {
        if (s.length()< t.length()){
            return "";
        }
        Map<Character, Integer> map =new HashMap<>();
        for (char c: t.toCharArray())
        {
            map.put(c, map.getOrDefault(c,0)+1);
        }
        Map<Character, Integer> window= new HashMap<>();
        int have=0, need= map.size();
        int left=0;
        int minLen= Integer.MAX_VALUE;
        int start=0;

        for (int right=0; right< s.length(); right++)
        {
            char c= s.charAt(right);
            window.put(c, window.getOrDefault(c,0)+1);
            if (map.containsKey(c) && window.get(c).intValue() == map.get(c).intValue())
            {
                have++;
            }
            while (have==need)
            {
                // update min window
                if (right-left+1 < minLen)
                {
                    minLen = right- left+1;
                    start= left;
                }
                // shrink from the left
                char leftChar= s.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);
                if (map.containsKey(leftChar) && window.get(leftChar) < map.get(leftChar))
                {
                    have--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "": s.substring(start, start+minLen);
    }
}
