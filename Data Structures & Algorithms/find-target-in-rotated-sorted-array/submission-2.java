class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;

        while (left <= right) {
            if (left + 1 == right) {
                if (nums[left] == target) return left;
                else if (nums[right] == target) return right;
                else return -1;
            }
            middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[left] > nums[middle]) {
                if (nums[right] >= target && nums[middle] < target) left = middle + 1;
                else right = middle - 1;
            } else {
                if (nums[left] <= target && nums[middle] > target) right = middle - 1;
                else left = middle + 1;
            }
        }

        return -1;
    }
}
