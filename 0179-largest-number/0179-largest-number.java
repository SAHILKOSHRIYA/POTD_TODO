// class Solution {
//     public String largestNumber(int[] nums) {
//         int  n=nums.length();
//         Array.sort(nums);
//         for(int i=0 ;i<=n;i++)
//         {
//               if(nums[i]>9)
//               {
                  
//               }
                 
//         }
        
//     }
// 
import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert the numbers to strings
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = Integer.toString(nums[i]);
        }

        // Custom comparator to sort based on the comparison of (b + a) vs (a + b)
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        // Early exit: If the first number is "0", the result is "0"
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // Build the result using StringBuilder for better performance in concatenation
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrs) {
            result.append(numStr);
        }

        return result.toString();
    }
}
