public class Solution {
    
    // DFS function to check if an island in grid2 is a sub-island in grid1
    private boolean dfs(int x, int y, int[][] grid1, int[][] grid2) {
        // If out of bounds or cell is water in grid2, return true (no violation)
        if (x < 0 || x >= grid2.length || y < 0 || y >= grid2[0].length || grid2[x][y] == 0) {
            return true;
        }
        
        // If cell is already visited, return true
        if (grid2[x][y] == -1) {
            return true;
        }

        // Mark the cell as visited
        grid2[x][y] = -1;
        
        // Initially assume this part of the island is a sub-island
        boolean isSubIsland = true;
        
        // If the corresponding cell in grid1 is water, then it's not a sub-island
        if (grid1[x][y] == 0) {
            isSubIsland = false;
        }
        
        // Explore all 4 directions (up, down, left, right) and combine results
        isSubIsland &= dfs(x + 1, y, grid1, grid2);
        isSubIsland &= dfs(x - 1, y, grid1, grid2);
        isSubIsland &= dfs(x, y + 1, grid1, grid2);
        isSubIsland &= dfs(x, y - 1, grid1, grid2);
        
        return isSubIsland;
    }
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int totalRows = grid2.length;
        int totalCols = grid2[0].length;
        int subIslandCount = 0;

        // Iterate over every cell in grid2
        for (int x = 0; x < totalRows; ++x) {
            for (int y = 0; y < totalCols; ++y) {
                // If the cell is land and not visited
                if (grid2[x][y] == 1) {
                    // Perform DFS to check if it's a sub-island
                    if (dfs(x, y, grid1, grid2)) {
                        subIslandCount++;
                    }
                }
            }
        }
        // Return the total count of sub-islands
        return subIslandCount;
    }
}
