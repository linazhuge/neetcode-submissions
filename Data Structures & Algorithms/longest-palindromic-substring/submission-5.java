class Solution {
    public String longestPalindrome(String s) {
        int length = 0;
        int index = 0;

        for (int i=0; i < s.length(); i++) {
            int r = i;
            int l = i;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) break;
                if (r - l + 1 > length) {
                    length = r - l + 1;
                    index = l;
                }
                l--;
                r++;
            }

            r = i + 1;
            l = i;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) break;
                if (r - l + 1 > length) {
                    length = r - l + 1;
                    index = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(index, index + length);
    }
}
