import java.util.ArrayList;
import java.util.List;

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int left = newInterval[0];
        int right = newInterval[1];
        boolean newIntervalPlaced = false;

        List<int[]> ansList = new ArrayList<int[]>();
        for(int[] interval : intervals) {
            if (interval[0] > right) {
                if (!newIntervalPlaced) {
                    ansList.add(new int[] {left, right});
                    newIntervalPlaced = true;
                }
                ansList.add(interval);
            }else if (interval[1] < left) {
                ansList.add(interval);
            }else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!newIntervalPlaced) {
            ansList.add(new int[] {left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}