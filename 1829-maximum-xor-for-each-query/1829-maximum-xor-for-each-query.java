class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        int xor_total = 0;

        // Step 1: Compute the XOR of all elements
        for (int num : nums) {
            xor_total ^= num;
        }

        // Step 2: Maximum k value
        int maxK = (1 << maximumBit) - 1;

        // Step 3: Iterate backwards
        for (int i = 0; i < n; i++) {
            answer[i] = xor_total ^ maxK;
            xor_total ^= nums[n - 1 - i];
        }

        return answer;
    }
}
