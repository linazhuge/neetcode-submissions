class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left + 1 == right) return Math.min(nums[left], nums[right]);
            int middle = (left + right) / 2;
            if (middle == 0) {
                if (nums[0] < nums[1] && nums[0] < nums[nums.length - 1]) return nums[0];
            } else if (middle == nums.length - 1) {
                if (nums[nums.length - 1] < nums[nums.length - 2] && nums[nums.length - 1] < nums[0]) return nums[nums.length - 1];
            } else if (nums[middle] < nums[middle + 1] && nums[middle] < nums[middle - 1]) {
                return nums[middle];
            } else if (nums[middle] > nums[left] && nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return nums[0];
    }
}