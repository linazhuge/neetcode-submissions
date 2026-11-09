class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] neighbors = new ArrayList[numCourses];

        for (int i=0; i < prerequisites.length; i++) {
            if (neighbors[prerequisites[i][1]] == null) {
                neighbors[prerequisites[i][1]] = new ArrayList<Integer>();
            }
            neighbors[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i=0; i < numCourses; i++) {
            HashSet<Integer> set = new HashSet<>();
            if (hasCycle(neighbors, set, i)) return false;
        }

        return true;
    }

    public boolean hasCycle(List<Integer>[] neighbors, HashSet<Integer> set, int node) {
        if (set.contains(node)) return true;
        set.add(node);
        boolean childCycle = false;
        if (neighbors[node] != null)  {
            for (int i=0; i < neighbors[node].size(); i++) {
                childCycle = childCycle | hasCycle(neighbors, set, neighbors[node].get(i));
            }
        }
        set.remove(node);

        return childCycle;
    }
}
