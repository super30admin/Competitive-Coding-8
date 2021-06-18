import java.util.*;
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] result = new int[3];
        result[0] = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        // HashMap<Character, Integer> charCountInWindow = new HashMap<>();
        for(int i = 0; i<= t.length()-1; i++)
        {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }
        
        int count=map.size(); int sp=0; int fp=0; int currentCharCount = 0;
        
        while(sp<=s.length()-t.length())
        {
            char charAtFp;
            while(fp <= s.length()-1 && count>0)
            {
                charAtFp = s.charAt(fp);
                if(map.containsKey(charAtFp))
                {
                    currentCharCount = map.get(charAtFp);
                    map.put(charAtFp, currentCharCount-1);
                    if(currentCharCount-1 == 0)
                        count--;
                }
                if(count==0)
                {
                    if(result[0]>fp-sp || result[0]==-1)
                    {
                        result[0] = fp-sp+1;
                        result[1] = sp;
                        result[2] = fp+1;
                    }
                    
                    //try squezing the window
                    int trav = sp;
                    while(trav<=fp && count==0)
                    {
                        trav++;
                        char outChar = s.charAt(trav-1);
                        if(map.containsKey(outChar))
                        {
                            currentCharCount = map.get(outChar);
                            map.put(outChar, currentCharCount+1);
                            if(currentCharCount==0)
                            {
                                count++;
                                if(count-1 == 0 && fp-trav+2 < result[0])
                                {
                                    result[0] = fp-trav+2;
                                    result[1] = trav-1;
                                    result[2] = fp+1;
                                }
                                sp = trav;
                                break; 
                            }
                        }
                    }
                }
                fp++;
            }
            sp++;
        }
        return s.substring(result[1],result[2]);
    }
}
