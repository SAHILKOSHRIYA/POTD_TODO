import java.util.*;

class Solution {
    public int removeStones(int[][] stones) {
        // Map to track visited stones
        Set<int[]> visited = new HashSet<>();
        int n = stones.length;
        int components = 0;
        
        // Perform DFS for each stone
        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                components++;
                dfs(stone, stones, visited);
            }
        }
        
        // The maximum number of stones that can be removed
        return n - components;
    }
    
    private void dfs(int[] stone, int[][] stones, Set<int[]> visited) {
        visited.add(stone);
        
        for (int[] otherStone : stones) {
            // If the stone is in the same row or column and not visited
            if (!visited.contains(otherStone) && (stone[0] == otherStone[0] || stone[1] == otherStone[1])) {
                dfs(otherStone, stones, visited);
            }
        }
    }
}
