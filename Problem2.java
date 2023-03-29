import java.util.HashMap;
import java.util.Map;
/*
Minimum window substring
approach: sliding window
time: O(m+n)
space: O(1)
 */
public class Problem2 {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        if (s.length()==1 && s.charAt(0)==t.charAt(0)) return s;
        Map<Character, Integer> map = new HashMap<>();
        for(int k=0;k<t.length();k++) {
            char c = t.charAt(k);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int i = 0, j=0;
        StringBuilder sb = new StringBuilder();
        String res = "";
        int match =0;
        while(j<s.length()) {
            char curr = s.charAt(j);
            if(map.containsKey(curr)) {
                char ichar = s.charAt(i);
                if(ichar==curr && map.get(curr)==0) {
                    i++;
                    sb.append(curr);
                    char temp = s.charAt(i);
                    while(i<=j && !map.containsKey(temp)) {
                        i++;
                        temp = s.charAt(i);
                    }

                    sb = new StringBuilder(sb.substring(sb.length()-(j-i)-1));
                }
                else {
                    map.put(curr, map.get(curr)-1);
                    if(map.get(curr)==0) match++;
                    sb.append(curr);
                }

                if(match==map.size()) {
                    if(res=="") {
                        res = sb.toString();
                    }
                    else if (sb.length()<res.length()){
                        res = sb.toString();
                    }
                    char out = s.charAt(i++);
                    char te = s.charAt(i);
                    while(i<j && !map.containsKey(te)) {
                        i++;
                        te = s.charAt(i);
                    }
                    sb = new StringBuilder(sb.substring(sb.length()-(j-i)-1));
                    if (map.containsKey(out))
                    {
                        map.put(out, map.get(out)+1);
                        if(map.get(out)==1) match--;
                    }
                }
            }
            else sb.append(curr);
            j++;
        }
        if (match==map.size() && sb.length()<res.length()) res = sb.toString();
        return res;
    }

    public static void main(String []args) {
        Problem2 problem2 = new Problem2();
        problem2.minWindow("ADOBECODEBANC", "ABC");
        problem2.minWindow("ab", "b");
        problem2.minWindow("abcdcanopqab", "aabcc");
    }
}
