import java.util.Arrays;

/**
 * leetcode34
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author mingzhi
 * @date 2020-12-01
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        if (nums.length == 1) {
            if (target == nums[0]) {
                return new int[] {0, 0};
            }else {
                return new int[] {-1, -1};
            }
        }
        int leftIdx = findFirstTarget(nums, target);
        if (leftIdx == -1) {
            return new int[]{-1, -1};
        }
        int rightIdx = findLastTarget(nums, target);
        return new int[]{leftIdx, rightIdx};
    }

    private int findLastTarget(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] == target) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int findFirstTarget(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] == target) {
                right = mid;
            }else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution34().searchRange(new int[] {5, 7, 7, 8, 8, 10}, 5)));
        System.out.println((Solution34.binarySearch(new int[] {1, 3, 4, 6, 7, 8}, 2)));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }else if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

}
