import java.util.HashMap;

class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> stateMap = new HashMap<>();
        stateMap.put(0, -1);  // Initial state for no vowels (bitmask 00000)

        int bitmask = 0;  // Initial bitmask (all vowels have appeared an even number of times)
        int maxLength = 0;  // To store the maximum length

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Toggle bits corresponding to the vowel
            if (ch == 'a') {
                bitmask ^= (1 << 0);  // Toggle 1st bit for 'a'
            } else if (ch == 'e') {
                bitmask ^= (1 << 1);  // Toggle 2nd bit for 'e'
            } else if (ch == 'i') {
                bitmask ^= (1 << 2);  // Toggle 3rd bit for 'i'
            } else if (ch == 'o') {
                bitmask ^= (1 << 3);  // Toggle 4th bit for 'o'
            } else if (ch == 'u') {
                bitmask ^= (1 << 4);  // Toggle 5th bit for 'u'
            }

            // If this bitmask has been seen before, calculate the length of the substring
            if (stateMap.containsKey(bitmask)) {
                maxLength = Math.max(maxLength, i - stateMap.get(bitmask));
            } else {
                // Otherwise, store the first occurrence of this bitmask
                stateMap.put(bitmask, i);
            }
        }

        return maxLength;
    }
}
