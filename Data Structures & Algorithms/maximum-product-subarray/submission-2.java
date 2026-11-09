class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int [] maxNeg = new int[nums.length];
        int [] maxPos = new int[nums.length];
        int max = 0;

        if (nums[0] < 0) maxNeg[0] = nums[0];
        if (nums[0] > 0) maxPos[0] = nums[0];

        for (int i=1; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] < 0) {
                if (maxPos[i-1] == 0) maxNeg[i] = nums[i];
                else maxNeg[i] = maxPos[i-1] * nums[i];
                maxPos[i] = maxNeg[i-1] * nums[i];
            } else {
                if (maxPos[i-1] == 0) maxPos[i] = nums[i];
                else maxPos[i] = maxPos[i-1] * nums[i];
                maxNeg[i] = maxNeg[i-1] * nums[i];
            }
            max = Math.max(maxPos[i], max);
        }

        return max;
    }
}
