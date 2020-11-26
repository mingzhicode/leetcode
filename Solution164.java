import java.util.Arrays;


/**
 * @author mingzhi
 * @date 2020-11-26
 */
public class Solution164 {

    public int maximumGap(int[] nums) {
        return sortAndLoop(nums);
    }

    public int sortAndLoop(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int gap;
        for (int i = 0; i + 1 <= nums.length - 1; i++) {
            gap = nums[i + 1] - nums[i];
            max = Math.max(max, gap);
        }
        return max;
    }
}
