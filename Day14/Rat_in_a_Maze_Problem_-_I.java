class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        
        find(maze, 0, 0, n, "", res, visited);
        
        Collections.sort(res);
        return res;
    }
    
    private void find(int[][] m, int i, int j, int n, String path, ArrayList<String> res, boolean[][] visited ){
        // Base case: out of bounds, blocked cell or already visited
        if(i < 0 || i >= n || j < 0 || j >= n || m[i][j] == 0 || visited[i][j]){
            return;
        }
        
        if(i == n-1 && j == n-1){
            res.add(path);
            return; 
        }
        
        visited[i][j] = true;
        find(m, i + 1, j, n, path + "D", res, visited); // Down
        find(m, i, j - 1, n, path + "L", res, visited); // Left
        find(m, i, j + 1, n, path + "R", res, visited); // Right
        find(m, i - 1, j, n, path + "U", res, visited); // Up
        visited[i][j] = false;
    }
}