/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 * 76. Minimum Window Substring
 * Intuition:
 1. Use a sliding window and a frequency map of `t` to track how many required characters are still needed.
 2. Expand the right pointer to include characters, decreasing their required count, and increment `matchCount` when a character’s requirement is fully satisfied.
 3. When all required characters are matched, shrink the window from the left to find the smallest valid substring, updating the minimum length along the way.
 * T.C: O(N)
   S.C: O(1) considering the map will even have 26 alphabets at the most. 
 * 
 */
var minWindow = function (s, t) {
    if (t.length > s.length) return '';
    let n = s.length;
    let start = 0;
    let matchCount = 0;
    let minLen = Infinity;
    let map = new Map();
    for (let ch of t) {
        let count = (map.get(ch) || 0) + 1;
        map.set(ch, count);
    }
    let left = 0;
    for (let right = 0; right < n; right++) {
        const incomingChar = s[right];
        if (map.has(incomingChar)) {
            let count = map.get(incomingChar);
            count--;
            if (count === 0) matchCount++;
            map.set(incomingChar, count);
        }
        while (matchCount === map.size) {
            // Update result
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                start = left;
            }
            const outGoingChar = s[left];
            if (map.has(outGoingChar)) {
                let count = map.get(outGoingChar);
                count++;
                if (count === 1) matchCount--;
                map.set(outGoingChar, count);
            }
            left++
        }
    }
    return minLen === Infinity ? '' : s.substr(start, minLen);
};