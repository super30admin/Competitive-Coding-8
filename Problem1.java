class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i =0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i)))
                map.put(t.charAt(i), map.size());
        }

        LinkedList<Integer> arr[] = new LinkedList[map.size()];

        for(int i=0;i<map.size();i++)
            arr[i] = new LinkedList<>();

        char c;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(map.containsKey(c))
                arr[map.get(s.charAt(i))].add(i);
        }



        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int max = -1;

        int num;
        int nextIndex;
        for(int i=0;i<t.length();i++){
            num = map.get(t.charAt(i));
            if(arr[num].isEmpty())
                return "";
            nextIndex = arr[num].poll();
            minHeap.add(nextIndex);
            max = Math.max(max, nextIndex);
        }
        int minLength = max - minHeap.peek() + 1;
        int resultLeft = minHeap.peek();
        int resultRight = max+1;

        int index;
        while(true){
            num = minHeap.poll();
            index = map.get(s.charAt(num));
            if(arr[index].isEmpty())
                break;
            nextIndex = arr[index].poll();
            minHeap.add(nextIndex);
            max = Math.max(max, nextIndex);
            if(minLength > max - minHeap.peek()+1){
                minLength = max - minHeap.peek()+1;
                resultLeft = minHeap.peek();
                resultRight = max+1;
            }
        }
        return s.substring(resultLeft, resultRight);
    }
}