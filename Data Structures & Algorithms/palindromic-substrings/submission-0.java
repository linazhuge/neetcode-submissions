class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i=0; i < s.length(); i++) {
            int r = i;
            int l = i;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) break;
                count++;
                l--;
                r++;
            }

            r = i + 1;
            l = i;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) break;
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
