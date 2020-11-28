/**
 * @author mingzhi
 * @date 2020-11-28
 */
public class Solution493 {

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        ReversePairsMethod mergeMethod = new MergeMethod();
        return mergeMethod.reversePairs(nums);
    }


    private interface ReversePairsMethod {
        int reversePairs(int[] nums);
    }


    private static class MergeMethod implements ReversePairsMethod{

        @Override
        public int reversePairs(int[] nums) {
            int[] sorted = new int[nums.length];
            return mergeSort(nums, sorted, 0, nums.length-1);
        }


        private int mergeSort(int[] nums, int[] sorted, int left, int right) {
            if (left >= right) {
                return 0;
            }
            int mid = left + (right - left) / 2;
            int res = mergeSort(nums, sorted, left, mid) +
                mergeSort(nums, sorted, mid + 1, right) +
                findPairsBetweenTwoArray(nums, left, right);
            //归并排序
            int i = left, j= mid + 1, k = left;
            while (i <= mid && j <= right) {
                if (nums[i] <= nums[j]) {
                    sorted[k] = nums[i];
                    k++;
                    i++;
                }else {
                    sorted[k] = nums[j];
                    k++;
                    j++;
                }
            }
            while (i <= mid) {
                sorted[k] = nums[i];
                k++;
                i++;
            }
            while (j <= right) {
                sorted[k] = nums[j];
                k++;
                j++;
            }
            for (int l = left; l <= right; l++) {
                nums[l] = sorted[l];
            }
            return res;
        }

        private int findPairsBetweenTwoArray(int[] nums, int left, int right) {
            int res = 0, mid = left + (right - left) / 2;
            int i = left;
            int j = mid + 1;
            for (; i <=mid; i++) {
                while (j <= right && (long)nums[i]> 2 * (long)nums[j]) {
                    //由于已经排序了，在left数组i之后的元素都是满足条件的
                    res += mid - i + 1;
                    j++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution493 solution493 = new Solution493();
        int[] test = new int[] {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(solution493.reversePairs(test));
    }
}
