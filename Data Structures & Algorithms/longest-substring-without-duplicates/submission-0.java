class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 1;
        int length = 0;
        while (right <= s.length()) {
            if (!hasDuplicates(s.substring(left, right))) {
                right++;
                length++;
            } else {
                left++;
                right++;
            }
        }

        return length;
    }

    public boolean hasDuplicates(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        return set.size() != s.length();
    }
}
