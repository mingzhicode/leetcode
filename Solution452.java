import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mingzhi
 * @date 2020-11-23
 */
public class Solution452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int pos = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > pos) {
                pos = point[1];
                ans++;
            }
        }
        return ans;
    }
}
