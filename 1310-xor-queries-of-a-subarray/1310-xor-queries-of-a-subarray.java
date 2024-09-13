class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Step 1: Compute the prefix XOR array
        int n = arr.length;
        int[] prefixXOR = new int[n];
        prefixXOR[0] = arr[0];
        
        // Build the prefix XOR array
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }

        // Step 2: Answer the queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            // XOR from left to right can be calculated using prefix XOR
            if (left == 0) {
                result[i] = prefixXOR[right];
            } else {
                result[i] = prefixXOR[right] ^ prefixXOR[left - 1];
            }
        }

        return result;
    }
}
