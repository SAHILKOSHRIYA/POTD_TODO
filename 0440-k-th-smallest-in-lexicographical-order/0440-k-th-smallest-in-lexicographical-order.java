class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;  // Decrease k since we are starting from 1

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr++;  // Move to the next sibling
                k -= steps;
            } else {
                curr *= 10;  // Move to the next level (child)
                k--;
            }
        }

        return curr;
    }

    // Helper function to count the number of steps between two prefixes
    private long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
