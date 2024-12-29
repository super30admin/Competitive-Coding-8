
# // Time Complexity : O(M*N)
# // Space Complexity :O(M*N)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : creating all possible words in range 26 gave me time limit exceeded.

# // Your code here along with comments explaining your approach

from collections import deque,defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list[str]) -> int:
        
        sdict = defaultdict(list)               # store word iterations lit ; h*t, *it, hi*
        q = deque()
        q.append((beginWord,1))
        wordsize = len(beginWord)

        for w in wordList:                      # iterate and form words; store them in sdict
            for l in range(wordsize):           # {do* : [dot, dog], h*t : hot}
                word = w[0:l] + '*' +w[l+1:]
                sdict[word].append(w)           

        visited = set()                         # hashset of visited words
        visited.add(beginWord)

        while q:                                # add sdict letters
            word,step = q.popleft()

            for i in range(wordsize):               # for every letter in word
                nw = word[:i] + "*" + word[i+1:]    # form the combinations
                for x in sdict[nw]:                 # iterate over sdict values
                    if x == endWord:                # if any word matches output
                        return step+1
                    if x not in visited:            # if its not already visited
                        visited.add(x)
                        q.append((x,step+1))        

        return 0         

        