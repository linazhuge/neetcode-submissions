class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> list = new HashSet<>();
        for (int i=0; i < nums.length - 2; i++) {
            int right_index = nums.length - 1;
            boolean breakO = false;
            for (int j=i+1; j < nums.length - 1; j++) {
                while (nums[i] + nums[j] + nums[right_index] >= 0) {
                    if (right_index <= j) {
                        breakO = true;
                        break;
                    }
                    if (nums[i] + nums[j] + nums[right_index] == 0) {
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[right_index]);
                        list.add(innerList);
                    }
                    right_index--;
                }
                if (breakO) break;
            }
        }

        return new ArrayList<>(list);
    }
}
