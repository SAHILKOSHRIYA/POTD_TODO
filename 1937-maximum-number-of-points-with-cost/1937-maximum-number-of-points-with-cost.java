class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] prev = new long[n];
        long[] curr = new long[n];
        
        // Initialize with the first row
        for (int j = 0; j < n; j++) {
            prev[j] = points[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            // Left to Right Pass
            long[] leftMax = new long[n];
            leftMax[0] = prev[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, prev[j]);
            }
            
            // Right to Left Pass
            long[] rightMax = new long[n];
            rightMax[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, prev[j]);
            }
            
            // Calculate current row's max points
            for (int j = 0; j < n; j++) {
                curr[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }
            
            // Move current row results to prev
            prev = curr.clone();
        }
        
        // The answer is the maximum value in the last row
        long result = 0;
        for (int j = 0; j < n; j++) {
            result = Math.max(result, prev[j]);
        }
        return result;
    }
    
    
}
