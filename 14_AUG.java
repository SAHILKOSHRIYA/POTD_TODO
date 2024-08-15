import java.util.Arrays;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;

            if (issmallpairs(nums, k, mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    private boolean issmallpairs(int[] nums, int k, int mid) {
        int count = 0, left = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) left++;
            count += right - left;
        }
        return (count >= k);
    }

    // Main method for testing the function
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {1, 3, 1};
        int k = 1;
        
        int result = solution.smallestDistancePair(nums, k);
        System.out.println("The k-th smallest distance pair is: " + result);
    }
}
