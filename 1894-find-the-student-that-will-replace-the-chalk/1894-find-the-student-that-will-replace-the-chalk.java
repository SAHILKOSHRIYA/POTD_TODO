class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Step 1: Calculate the total chalk used in one round.
        long totalChalk = 0;
        for (int chalkUsed : chalk) {
            totalChalk += chalkUsed;
        }

        // Step 2: Reduce k by total chalk usage in one round.
        k %= totalChalk;

        // Step 3: Identify the student who will replace the chalk.
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }

        // This return statement should technically never be reached.
        return -1;
    }
}
