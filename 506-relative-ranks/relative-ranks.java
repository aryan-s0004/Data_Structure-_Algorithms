class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[][] athletes = new int[n][2];

        for (int i = 0; i < n; i++) {
            athletes[i][0] = score[i];
            athletes[i][1] = i;
        }

    
        Arrays.sort(athletes, (a, b) -> Integer.compare(b[0], a[0]));

        String[] ans = new String[n];

        for (int rank = 0; rank < n; rank++) {
            int originalIndex = athletes[rank][1];

            if (rank == 0) {
                ans[originalIndex] = "Gold Medal";
            } else if (rank == 1) {
                ans[originalIndex] = "Silver Medal";
            } else if (rank == 2) {
                ans[originalIndex] = "Bronze Medal";
            } else {
                ans[originalIndex] = String.valueOf(rank + 1);
            }
        }

        return ans;
    }
}