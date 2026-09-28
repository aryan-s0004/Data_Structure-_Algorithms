 class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (freq[c - 'a'] < k) {
                String left = s.substring(0, i);
                String right = s.substring(i + 1);

                return Math.max(
                    longestSubstring(left, k),
                    longestSubstring(right, k)
                );
            }
        }

        return s.length();
    }
}