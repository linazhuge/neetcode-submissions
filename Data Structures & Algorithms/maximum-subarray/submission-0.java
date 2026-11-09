class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int longest = nums[0];
        for (int i=0; i < nums.length; i++) {
            sum += nums[i];
            longest = Math.max(sum, longest);
            if (sum < 0) sum = 0;
        }

        return longest;
    }
}
