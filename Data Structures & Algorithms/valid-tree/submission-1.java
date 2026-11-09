class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] neighbors = new ArrayList[n];
        for (int i=0; i < n; i++) {
            neighbors[i] = new ArrayList<>();
        }
        
        for (int i=0; i < edges.length; i++) {
            neighbors[edges[i][0]].add(edges[i][1]);
            neighbors[edges[i][1]].add(edges[i][0]);
        }

        HashSet<Integer> set = new HashSet<>();
        if (hasCycle(neighbors, 0, set, -1)) return false;
        if (set.size() != n) return false;

        return true;
    }

    public boolean hasCycle(List<Integer>[] neighbors, int n, HashSet<Integer> set, int parent) {
        if (set.contains(n)) return true;
        set.add(n);

        boolean childCycle = false;
        for (int i=0; i < neighbors[n].size(); i++) {
            if (neighbors[n].get(i) == parent) continue; 
            childCycle = childCycle | hasCycle(neighbors, neighbors[n].get(i), set, n);
        }

        return childCycle;
    }
}
