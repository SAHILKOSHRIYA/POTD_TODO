import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1; // The first ugly number is 1
        int i2 = 0, i3 = 0, i5 = 0; // Pointers for multiples of 2, 3, and 5

        for (int i = 1; i < n; i++) {
            // Next ugly number is the minimum of these three values
            int next_ugly = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            dp[i] = next_ugly;

            // Increment the pointer(s) whose value was used
            if (next_ugly == dp[i2] * 2) i2++;
            if (next_ugly == dp[i3] * 3) i3++;
            if (next_ugly == dp[i5] * 5) i5++;
        }

        return dp[n - 1]; // Return the nth ugly number
    }

    
}
