class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q =[] #dot, lot

        q.append(beginWord)
        count = 0
        seen = set()
        seen.add(beginWord)
        wordList = set(wordList)

        while q:
            count += 1

            for l in range(len(q)):
                cur = q.pop(0)
                # print(cur)
                if cur == endWord:
                    return count
            
                for i in range(len(cur)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        new_s = cur[:i] + c + cur[i+1:] 
                        if new_s in wordList and new_s not in seen:
                            seen.add(new_s)
                            q.append(new_s)
            
        return 0
        
