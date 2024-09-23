class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Initialize the dp array: maximum extra characters for each position
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        
        // Check each position in the string
        for (int i = 1; i <= n; i++) {
            // Check all words in the dictionary
            for (String word : dictionary) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = Math.min(dp[i], dp[i - len]);
                }
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1); // Either we leave s[i-1] as an extra character
        }
        
        return dp[n];
    }
}
