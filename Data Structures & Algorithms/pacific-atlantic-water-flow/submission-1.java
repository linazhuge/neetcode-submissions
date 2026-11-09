class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();

        int [][] pacific = new int[heights.length][heights[0].length];
        int [][] atlantic = new int[heights.length][heights[0].length];
        for (int i=0; i < heights.length; i++) {
            for (int j=0; j < heights[0].length; j++) {
                if (pacific[i][j] == -1) pacific[i][j] = 0;
                if (atlantic[i][j] == -1) atlantic[i][j] = 0;
                if (reachesPacific(i, j, heights, pacific, true) == 1 && reachesPacific(i, j, heights, atlantic, false) == 1) {
                    List<Integer> innerList = new ArrayList<>();
                    innerList.add(i);
                    innerList.add(j);
                    list.add(innerList);
                }
            }
        }

        return list;
    }

    public int reachesPacific(int i, int j, int[][] heights, int[][] visited, boolean isPacific) {
        if (visited[i][j] == -1) return -1;
        if (isPacific && (i == 0 || j == 0)) {
            visited[i][j] = 1;
            return 1;
        }
        if (!isPacific && (i == heights.length - 1 || j == heights[0].length - 1)) {
            visited[i][j] = 1;
            return 1;
        }

        if (visited[i][j] == 1 || visited[i][j] == 2) return visited[i][j];

        int left = 2;
        int right = 2;
        int top = 2;
        int bottom = 2;
        visited[i][j] = -1;
        if (j > 0 && heights[i][j] >= heights[i][j-1]) left = reachesPacific(i, j-1, heights, visited, isPacific);
        if (j < heights[0].length - 1 && heights[i][j] >= heights[i][j+1]) right = reachesPacific(i, j+1, heights, visited, isPacific);
        if (i > 0 && heights[i][j] >= heights[i-1][j]) top = reachesPacific(i-1, j, heights, visited, isPacific);
        if (i < heights.length - 1 && heights[i][j] >= heights[i+1][j]) bottom = reachesPacific(i+1, j, heights, visited, isPacific);
        if (left == 1 || right == 1 || top == 1 || bottom == 1) visited[i][j] = 1;
        else if (left == -1 || right == -1 || top == -1 || bottom == -1) visited[i][j] = -1;
        else visited[i][j] = 2;        
        return visited[i][j];
    }
}
