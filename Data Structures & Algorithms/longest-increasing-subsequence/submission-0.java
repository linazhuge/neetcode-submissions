class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        int max = 0;
        
        for (int i=0; i < nums.length; i++) {
            LIS[i] = 1;
            for (int j=0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
            max = Math.max(LIS[i], max);
        }

        return max;
    }
}
