

/**
 * @author mingzhi
 * @date 2020-11-19
 */
public class Solution283 {

    public void moveZeroes(int[] nums) {
        useSort(nums);
    }

    public void loopOnce(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        int zeroIndex = 0;
        int nextNotZeroIndex = 0;
        while (zeroIndex < len) {
            if (nums[zeroIndex] != 0) {
                swap(nums, zeroIndex, nextNotZeroIndex);
                nextNotZeroIndex++;
            }
            zeroIndex++;
        }
    }

    private void swap(int[] nums, int zeroIndex, int nextNotZeroIndex) {
        int tmp = nums[zeroIndex];
        nums[zeroIndex] = nums[nextNotZeroIndex];
        nums[nextNotZeroIndex] = tmp;
    }

    public void useSort(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = i; j < len; j++) {
                if (j + 1 < len) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

}
