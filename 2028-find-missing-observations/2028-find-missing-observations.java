class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = (n + m) * mean;  // Total sum of all n + m rolls
        int sumOfRolls = 0;

        // Calculate the sum of the given rolls
        for (int roll : rolls) {
            sumOfRolls += roll;
        }

        // Calculate the sum of the missing rolls
        int missingSum = totalSum - sumOfRolls;

        // If the missing sum is not possible to distribute in the range [n, 6n], return []
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        // Create an array to store the missing rolls
        int[] missingRolls = new int[n];

        // Distribute the missing sum across the missing rolls
        for (int i = 0; i < n; i++) {
            // Assign as much as possible to each roll, but not more than 6
            missingRolls[i] = Math.min(6, missingSum - (n - i - 1));
            missingSum -= missingRolls[i];
        }

        return missingRolls;
    }
}
