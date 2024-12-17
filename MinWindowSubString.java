// Time : O(n)
// Space : O(1)
class Solution {
    public String minWindow(String s, String t) {
        // base case
        if(s.length()==0 || t.length() ==0) return "";
        HashMap<Character,Integer> nmap = new HashMap<>();

        for(int i = 0;i<t.length();i++){
            char need = t.charAt(i);
            nmap.put(need,nmap.getOrDefault(need,0)+1);
        }
        int left = 0;
        int right =0;
        int need = nmap.size();
        int have = 0;
        int[] res = new int[]{-1,0,0};

        Map<Character,Integer> wmap = new HashMap<>();
        while(right<s.length()){
            char ch = s.charAt(right);
            wmap.put(ch,wmap.getOrDefault(ch,0)+1);
            if(nmap.containsKey(ch) && nmap.get(ch).intValue() == wmap.get(ch).intValue()){
                have++;
            }
            while(left<=right && have == need){
                char chl = s.charAt(left); 
                if(res[0] ==-1 || right-left+1 <res[0]){
                    res[0] = right-left+1;
                    res[1] = left;
                    res[2] = right;
                }
                wmap.put(chl,wmap.get(chl)-1); // pop the left character
                if(nmap.containsKey(chl) && wmap.get(chl).intValue() < nmap.get(chl).intValue()){
                    have--; // decrement have count if popped charcater is part of nmap and if the count is matched or less
                }
                // try to form new window
                left++;
            }
            // increment the window size
            right ++;
        }
        return res[0] == -1 ? "" : s.substring(res[1],res[2]+1);
    }
}