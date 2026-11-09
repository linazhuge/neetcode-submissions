class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        int longest = 0;
        for (int x : nums) {
            int length = 1;
            if (!set.contains(x - 1)) {
                while (true) {
                    if (set.contains(x+1)) {
                        length++;
                        x++;
                    } else {
                        break;
                    }
                }
                if (length > longest) longest = length;
            }
        }

        return longest;
    }
}
