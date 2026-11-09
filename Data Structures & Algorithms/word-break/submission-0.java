class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] contains = new boolean[s.length()];

        for (int i=0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (s.substring(0, i+1).equals(word)) {
                    contains[i] = true;
                } else if (s.substring(0, i+1).endsWith(word) && contains[i - word.length()]) contains[i] = true;
                if (contains[i]) break;
            }
        }

        return contains[s.length() - 1];
    }
}
