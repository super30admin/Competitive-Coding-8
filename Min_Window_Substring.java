import java.util.HashMap;

public class Min_Window_Substring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0, count = 0;
        int[] res = { Integer.MAX_VALUE, 0, 0 };
        HashMap<Character, Integer> smap = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);
            smap.put(c, smap.getOrDefault(c, 0) + 1);

            if (tmap.containsKey(c) && smap.get(c).intValue() == tmap.get(c).intValue()) {
                count++;
            }

            while (l <= r && count == tmap.size()) {
                if (res[0] > r - l + 1) {
                    res[0] = r - l + 1;
                    res[1] = l;
                    res[2] = r;
                }

                char lc = s.charAt(l);
                smap.put(lc, smap.get(lc) - 1);
                if (tmap.containsKey(lc) && smap.get(lc) < tmap.get(lc)) {
                    count--;
                }
                l++;
            }
            r++;
        }

        return res[0] == Integer.MAX_VALUE ? "" : s.substring(res[1], res[2] + 1);
    }

    public static void main(String[] args) {
        Min_Window_Substring m = new Min_Window_Substring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = m.minWindow(s, t);
        System.out.println(res);
    }
}
