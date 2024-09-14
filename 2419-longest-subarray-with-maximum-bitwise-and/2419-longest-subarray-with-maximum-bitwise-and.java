class Solution {
    public int longestSubarray(int[] nums) {
        // Step 1: Find the maximum value in the array
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 2: Find the longest subarray where all elements are equal to maxVal
        int longest = 0;
        int currentLength = 0;
        
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;
                longest = Math.max(longest, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return longest;
    }
}
