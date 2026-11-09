class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char left_char = Character.toLowerCase(s.charAt(left));
            if (!Character.isLetterOrDigit(left_char)) {
                left++;
                continue;
            }
            char right_char = Character.toLowerCase(s.charAt(right));
            if (!Character.isLetterOrDigit(right_char)) {
                right--;
                continue;
            }

            if (left_char != right_char) return false;
            left++;
            right--;

        }

        return true;
    }
}
 