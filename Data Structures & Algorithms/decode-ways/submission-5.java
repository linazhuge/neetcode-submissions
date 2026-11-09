class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int [] numWays = new int[s.length()];
        numWays[0] = 1;
        
        for (int i=1; i < numWays.length; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) != '1' && s.charAt(i-1) != '2') return 0;
                if (i == 1) numWays[i] = 1;
                else numWays[i] = numWays[i-2];
            }
            else {
                if (s.charAt(i-1) == '1') {
                    if (i > 1) numWays[i] = numWays[i-1] + numWays[i-2];
                    else numWays[i] = 2;
                } else if (s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                    if (i > 1) numWays[i] = numWays[i-1] + numWays[i-2];
                    else numWays[i] = 2;
                } else {
                    numWays[i] = numWays[i-1];
                }
            }
        }

        return numWays[s.length() - 1];
    }
}
