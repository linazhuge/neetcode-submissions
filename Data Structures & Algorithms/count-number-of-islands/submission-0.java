class UF {
    int [] parent;
    int numComponents;

    public UF(int x) {
        numComponents = x;
        parent = new int[x];
        for (int i=0; i < x; i++) {
            parent[i] = i;
        }
        System.out.println(numComponents);
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }

        return parent[i];
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;
        parent[rootA] = rootB;

        numComponents--;
    }

    public void subComponent() {
        numComponents--;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        UF uf = new UF(grid.length * grid[0].length);
        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if ((i + 1) < grid.length && grid[i+1][j] == '1') uf.union(i * grid[0].length + j, (i+1) * grid[0].length + j);
                    if ((j + 1) < grid[0].length && grid[i][j+1] == '1') uf.union(i * grid[0].length + j, i * grid[0].length + j + 1);
                } else {
                    uf.subComponent();
                }
            }
        }

        return uf.numComponents;
    }
}
