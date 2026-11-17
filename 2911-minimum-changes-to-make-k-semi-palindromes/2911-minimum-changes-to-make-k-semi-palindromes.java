class Solution {
    private Integer[][] memoCost;
    private Integer[][] memoDp;
    private String s;
    private int n;

    public int minimumChanges(String s, int k) {
        this.s = s;
        this.n = s.length();
        memoCost = new Integer[n][n];
        memoDp = new Integer[n][k + 1];
        
        return solveDp(0, k);
    }

    // DP to partition suffix s[i...] into j parts
    private int solveDp(int i, int j) {
        if (i == n) {
            return j == 0 ? 0 : 1000000;
        }
        if (j == 0) {
            return 1000000;
        }
        if (memoDp[i][j] != null) {
            return memoDp[i][j];
        }

        int minChanges = 1000000;
        // Try every possible end point 'x' for the current substring
        for (int x = i; x < n; x++) {
            int currentCost = getMinSemiPalindromeCost(i, x);
            minChanges = Math.min(minChanges, currentCost + solveDp(x + 1, j - 1));
        }

        return memoDp[i][j] = minChanges;
    }

    // Find minimum changes to make s[i...j] a semi-palindrome
    private int getMinSemiPalindromeCost(int i, int j) {
        if (memoCost[i][j] != null) {
            return memoCost[i][j];
        }

        int len = j - i + 1;
        if (len < 2) {
            return 1000000; // Length 1 cannot be a semi-palindrome
        }

        int minChanges = 1000000;

        // Check all proper divisors of 'len'
        for (int d = 1; d < len; d++) {
            if (len % d == 0) {
                int changes = 0;
                // For each group determined by divisor d
                for (int offset = 0; offset < d; offset++) {
                    // Count mismatches to make this group a palindrome
                    int left = i + offset;
                    int right = i + (len - 1) - (d - 1 - offset); // corresponding end of the group
                    // Alternatively, step by d:
                    // We can collect characters at indices i + offset + k * d
                    List<Character> group = new ArrayList<>();
                    for (int idx = i + offset; idx <= j; idx += d) {
                        group.add(s.charAt(idx));
                    }
                    
                    int l = 0, r = group.size() - 1;
                    while (l < r) {
                        if (!group.get(l).equals(group.get(r))) {
                            changes++;
                        }
                        l++;
                        r--;
                    }
                }
                minChanges = Math.min(minChanges, changes);
            }
        }

        return memoCost[i][j] = minChanges;
    }
}