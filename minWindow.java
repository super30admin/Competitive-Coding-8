
// Time Complexity : O(S + T)
// Space Complexity : O(S + T)


class Problem2 {
        public String minWindow(String s, String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            int minWin = -1;
            int right = 0;
            int left = 0;

            HashMap<Character, Integer> mapT = new HashMap<>();
            HashMap<Character, Integer> winMap = new HashMap<>();

            for(int i=0;i<t.length();i++){
                char c2 = t.charAt(i);
                mapT.put(c2, mapT.getOrDefault(c2, 0) + 1);
            }

            int found = 0;
            int r = 0;
            int l = 0;

            while(r < s.length()){

                char c = s.charAt(r);
                winMap.put(c, winMap.getOrDefault(c, 0) + 1);

                if(mapT.containsKey(c) && mapT.get(c).equals(winMap.get(c))){
                    found++;
                }

                while(l<= r && found == mapT.size()){
                    char c1 = s.charAt(l);

                    if(minWin == -1 || (r-l+1) < minWin){
                        minWin = r-l+1;
                        right = r;
                        left = l;
                    }

                    winMap.put(c1, winMap.get(c1)-1);

                    if(mapT.containsKey(c1) && winMap.get(c1).intValue() < mapT.get(c1).intValue()){
                        found--;
                    }

                    l++;
                }
                r++;
            }
            return minWin == -1? "": s.substring(left, right+1);

        }
    } 