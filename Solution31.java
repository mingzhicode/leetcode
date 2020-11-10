/**
 * @author mingzhi
 * @date 2020-11-10
 */
public class Solution31 {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int lastIndex = nums.length - 1;
        int point = lastIndex - 1;

        //找到第一个小于右邻居的数
        while (point >= 0 && nums[point] >= nums[point+1]) {
            point--;
        }
        //没有这样的point即表明整个序列是从大到小的，直接反转即可
        if (point < 0) {
            reverse(nums, 0, lastIndex);
        }
        //再次从右开始寻找第一个比point指向的数大的
        if (point >= 0) {
            int index = lastIndex;
            while (index >= 0 && nums[index] <= nums[point]) {
                index--;
            }
            //找到了这个数交换index和point的数
            swap(nums, point, index);
            //将point后面的数升序，即reverse即可，因为当前序列特定决定了右边的数是从大到小的
            reverse(nums, point+1, lastIndex);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swap(nums, startIndex++, endIndex--);
        }
    }
}
