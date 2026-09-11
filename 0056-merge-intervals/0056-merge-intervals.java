import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[][] temp = new int[intervals.length][2];
        int idx = 0;

        temp[0] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= temp[idx][1]) {
                temp[idx][1] = Math.max(temp[idx][1], intervals[i][1]);
            } else {
                idx++;
                temp[idx] = intervals[i];
            }
        }

        return Arrays.copyOf(temp, idx + 1);
    }
}
