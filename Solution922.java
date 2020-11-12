import java.util.ArrayList;
import java.util.List;

/**
 * @author mingzhi
 * @date 2020-11-12
 */
public class Solution922 {

    public int[] sortArrayByParityII(int[] A) {
        if (A.length == 0) {
            return A;
        }
        return loopOnce(A);
    }

    public int[] splitTwoList(int[] A) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (int i : A) {
            if (i %2 == 0) {
                evens.add(i);
            }else {
                odds.add(i);
            }
        }
        for (int i = 0; i < A.length; i++) {
            int index = i / 2;
            if (i % 2 == 0) {
                A[i] = evens.get(index);
            }else {
                A[i] = odds.get(index);
            }
        }
        return A;
    }

    public int[] loopOnce(int[] nums) {
        int evenNeedSwapIndex = 0, oddNeedSwapIndex = 1;

        for (evenNeedSwapIndex = 0; evenNeedSwapIndex < nums.length; evenNeedSwapIndex+=2) {
            if (nums[evenNeedSwapIndex] % 2 == 1) {
                while (nums[oddNeedSwapIndex] % 2 == 1) {
                    oddNeedSwapIndex+=2;
                }
                swap(nums, evenNeedSwapIndex, oddNeedSwapIndex);
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
