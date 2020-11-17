import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author mingzhi
 * @date 2020-11-17
 */
public class Solution1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        return   saveAndSort(R, C, r0, c0);
    }

    public int[][] saveAndSort(int r, int c, int r0, int c0) {
        int[][] ret = new int[r * c][];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i * c + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, (dot1, dot2) -> {
            int disA = dist(dot1[0], dot1[1], r0, c0);
            int disB = dist(dot2[0], dot2[1], r0, c0);
            return disA - disB;
        });
        return ret;
    }

    public int[][] bucketSort(int r, int c, int r0, int c0) {
        int max = Math.max(r0, r - 1 -r0) + Math.max(c0, c - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[] {i, j});
            }
        }
        int[][] ret = new int[r * c][];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int[] ints : bucket.get(i)) {
                ret[index++] = ints;
            }
        }
        return ret;
    }

    private int dist(int r1, int c1, int r2, int c2) {
       return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
