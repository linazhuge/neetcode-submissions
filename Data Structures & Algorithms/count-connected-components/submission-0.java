class UnionFind {
    int numComponents;
    int [] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i=0; i < n; i++) {
            parent[i] = i;
        }

        numComponents = n;
    }

    public int find(int i) {
        if (parent[i] != i) parent[i] = find(parent[i]);

        return parent[i];
    }

    public void union(int a, int b) {
        int nodeA = find(a);
        int nodeB = find(b);

        if (nodeA == nodeB) return;

        parent[nodeA] = nodeB;
        numComponents--;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int i=0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }

        return uf.numComponents;
    }
}
