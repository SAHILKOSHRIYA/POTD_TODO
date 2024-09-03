class Solution {
    public int getLucky(String s, int k) {
        // Step 1: Convert the string to its corresponding numerical representation
        StringBuilder numStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            numStr.append(c - 'a' + 1);
        }
        
        // Step 2: Sum the digits of the numerical representation
        int sum = 0;
        for (char c : numStr.toString().toCharArray()) {
            sum += c - '0';
        }
        
        // Step 3: Repeat the transformation k times
        for (int i = 1; i < k; i++) {
            int newSum = 0;
            while (sum > 0) {
                newSum += sum % 10;
                sum /= 10;
            }
            sum = newSum;
        }
        
        return sum;
    }
}
