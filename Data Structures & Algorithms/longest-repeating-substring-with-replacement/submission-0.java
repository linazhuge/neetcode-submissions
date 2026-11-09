class Solution {
    public int characterReplacement(String s, int k) {
        char [] letters = new char[26];
        int left = 0;
        int right = 0;
        int length = 0;
        while (right < s.length()) {
            letters[s.charAt(right)-'A']++;
            boolean isValid = false;
            for (int i=0; i < 26; i++) {
                if (letters[i] + k >= length + 1) {
                    isValid = true;
                    break;
                }
            }

            if (isValid) {
                length++;
                right++;
            } else {
                right++;
                letters[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return length;
    }
}
