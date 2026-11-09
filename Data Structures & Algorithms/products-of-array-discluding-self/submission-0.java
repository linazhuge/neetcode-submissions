class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] prod = new int [nums.length];
        int count0 = 0;

        int total = 1;
        for (int x : nums) {
            if (x == 0) count0++;
            else total *= x;
        }

        for (int i=0; i < nums.length; i++) {
            if (nums[i] == 0 && count0 == 1) prod[i] = total;
            else if (count0 >= 1) prod[i] = 0;
            else prod[i] = total / nums[i];
        }

        return prod;
    }
}  
