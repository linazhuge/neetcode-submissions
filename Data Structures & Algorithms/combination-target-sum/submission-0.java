class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        rec(nums, 0, target, list, new ArrayList<>());
        return list;
    }

    public void rec(int[] nums, int left, int target, List<List<Integer>> outer, List<Integer> inner) {
        for (int i=left; i < nums.length; i++) {
            List<Integer> copy = new ArrayList<>(inner);
            if (nums[i] > target) break;
            if (nums[i] == target) {
                copy.add(nums[i]);
                outer.add(copy);
            } else {
                copy.add(nums[i]);
                rec(nums, i, target - nums[i], outer, copy);
            }
        }
    }
}
