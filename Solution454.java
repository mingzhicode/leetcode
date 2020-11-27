import java.util.HashMap;
import java.util.Map;

/**
 * @author mingzhi
 * @date 2020-11-27
 */
public class Solution454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        return useHashAndLoop(A, B, C, D);
    }

    private int useHashAndLoop(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> sumCountsAB = new HashMap<>();
        for (int valA : a) {
            for (int valB : b) {
                sumCountsAB.put(valA + valB, sumCountsAB.getOrDefault(valA + valB, 0) + 1);
            }
        }
        int ans = 0;
        for (int valC : c) {
            for (int valD : d) {
                if (sumCountsAB.containsKey(-(valC + valD))) {
                    ans += sumCountsAB.get(-(valC + valD));
                }
            }
        }
        return ans;
    }


}
