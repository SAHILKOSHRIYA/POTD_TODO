import java.util.Collections;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // Convert time points to minutes and store in a list
        List<Integer> minutesList = new ArrayList<>();
        
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int totalMinutes = hours * 60 + minutes;
            minutesList.add(totalMinutes);
        }
        
        // Sort the time points in minutes
        Collections.sort(minutesList);
        
        // Initialize minDifference to a large number (maximum time difference in a day is 1440 minutes)
        int minDifference = 1440;
        
        // Compute the minimum difference between consecutive time points
        for (int i = 1; i < minutesList.size(); i++) {
            int diff = minutesList.get(i) - minutesList.get(i - 1);
            minDifference = Math.min(minDifference, diff);
        }
        
        // Check the difference between the last and first time point (circular difference)
        int circularDiff = 1440 - minutesList.get(minutesList.size() - 1) + minutesList.get(0);
        minDifference = Math.min(minDifference, circularDiff);
        
        return minDifference;
    }
}
