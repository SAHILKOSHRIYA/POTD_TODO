// class Solution {
//     public int countConsistentStrings(String allowed, String[] words) {
//         // Create the allowed bitmask
//         int allowedMask = 0;
//         for (char ch : allowed.toCharArray()) {
//             allowedMask |= (1 << (ch - 'a'));
//         }
        
//         int consistentCount = 0;
        
//         // Loop through each word in the words array
//         for (String word : words) {
//             int wordMask = 0;
//             // Create bitmask for the current word
//             for (char ch : word.toCharArray()) {
//                 wordMask |= (1 << (ch - 'a'));
//             }
            
//             // If wordMask & allowedMask == wordMask, the word is consistent
//             if ((wordMask & allowedMask) == wordMask) {
//                 consistentCount++;
//             }
//         }
        
//         return consistentCount;
//     }
// }
//**********************************Approach 2************************************


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Convert allowed string into a set of characters
        Set<Character> allowedSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }
        
        int consistentCount = 0;
        
        // Loop through each word in the words array
        for (String word : words) {
            boolean isConsistent = true;
            
            // Check if all characters in the word are in the allowed set
            for (char ch : word.toCharArray()) {
                if (!allowedSet.contains(ch)) {
                    isConsistent = false;
                    break;
                }
            }
            
            if (isConsistent) {
                consistentCount++;
            }
        }
        
        return consistentCount;
    }
}

