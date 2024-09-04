import java.util.HashSet;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions: north, east, south, west
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        int x = 0, y = 0; // initial position
        int direction = 0; // initially facing north
        int maxDistanceSquared = 0;
        
        for (int command : commands) {
            if (command == -2) {
                // turn left
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                // turn right
                direction = (direction + 1) % 4;
            } else {
                // move forward
                for (int i = 0; i < command; i++) {
                    int nextX = x + dx[direction];
                    int nextY = y + dy[direction];
                    
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                    } else {
                        break; // stop moving if there is an obstacle
                    }
                }
            }
        }
        
        return maxDistanceSquared;
    }
}
