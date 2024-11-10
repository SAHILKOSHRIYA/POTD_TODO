import java.util.*;

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Long, Integer> orMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            Map<Long, Integer> currentMap = new HashMap<>();
            long currentOr = nums[i];
            currentMap.put(currentOr, 1);
            if (currentOr >= k) {
                minLength = Math.min(minLength, 1);
            }

            for (Map.Entry<Long, Integer> entry : orMap.entrySet()) {
                long newOr = entry.getKey() | nums[i];
                int newLength = entry.getValue() + 1;
                if (!currentMap.containsKey(newOr) || newLength < currentMap.get(newOr)) {
                    currentMap.put(newOr, newLength);
                    if (newOr >= k) {
                        minLength = Math.min(minLength, newLength);
                    }
                }
            }

            orMap = currentMap;
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
